var Web3 = require('web3');
// Interaction with GPIO
var Gpio = require('onoff').Gpio

// defaults (if no command line parameter provided)
var ethNode = 'http://10.5.18.144:8545'
var secrKey = "318fbe62c7115d5909ecdd15fa23bdc5340341dd45e0c47a8e1743522442d215";
var contr_addr = "0x6734f578dbcd6c2e6637cfbf29f174cece2de425";

var gasPrice = '20000000000'; // default gas price in wei, 20 gwei in this case
var gas = '3000000';

if (process.argv.slice(2).length) {ethNode = process.argv.slice(2)[0]};
if (process.argv.slice(3).length) {secrKey = process.argv.slice(3)[0]};
if (process.argv.slice(4).length) {contr_addr = process.argv.slice(4)[0]};
if (process.argv.slice(5).length) {gasPrice = process.argv.slice(5)[0]};
if (process.argv.slice(6).length) {gas = process.argv.slice(6)[0]};

var abi_file = "abi.json";


// components connected to the RPi
var greenLed = new Gpio(14, 'out')

web3 = new Web3(new Web3.providers.HttpProvider(ethNode)); 

web3.eth.accounts.wallet.add('0x'+secrKey);
var sens_addr = web3.eth.accounts.wallet[0].address;

var fs = require('fs');
 
var abi = fs.readFileSync(abi_file, 'utf8');
// console.log(abi);

var Contract = new web3.eth.Contract(JSON.parse(abi), contr_addr, {from: sens_addr, gasPrice: gasPrice});

Contract.methods.MyTokens().call().then(result => {console.log('MyTokens: ', result)});

function checkState() {
    Contract.methods.IsActive().call().then(result => {
        var i = result ? 1 : 0;
        greenLed.writeSync(i);
        console.log(i)
    });
  console.log('checkState');
}

function step() {
    Contract.methods.Step().send({gas: '3000000'}).on('transactionHash', function(hash){
        console.log('hash');
        console.log(hash);
    }).on('receipt', function(receipt){
        console.log('receipt');
        console.log(receipt);
    }).on('error', console.error);
}

checkIntervalId1 = setInterval(step, 60*1000);
checkIntervalId2 = setInterval(checkState, 3000);
// clearInterval(checkIntervalId);



// checkState();
