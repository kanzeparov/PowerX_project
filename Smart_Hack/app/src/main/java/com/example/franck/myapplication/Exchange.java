package org.web3j.example.generated;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.4.0.
 */
public class Exchange extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50604051602080610438833981016040525160018054600160a060020a031916905560028054600160a860020a03191690556003556103e4806100546000396000f3006080604052600436106100a35763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166307eac9a081146100a85780630e62578b146100b5578063304dd754146100dc5780637da1f6bf14610105578063974c86b51461011a578063a714c2c41461012f578063aea90cb81461013a578063b43261f31461014f578063bedf0f4a14610164578063e8f1736c14610179575b600080fd5b6100b360043561018e565b005b3480156100c157600080fd5b506100ca610214565b60408051918252519081900360200190f35b3480156100e857600080fd5b506100f1610232565b604080519115158252519081900360200190f35b34801561011157600080fd5b506100ca610253565b34801561012657600080fd5b506100b3610271565b6100b3600435610292565b34801561014657600080fd5b506100b36102c2565b34801561015b57600080fd5b506100b36102e3565b34801561017057600080fd5b506100b361034b565b34801561018557600080fd5b506100b3610382565b600154600160a060020a031615156101a557600080fd5b600254600160a060020a031615156101bc57600080fd5b60028054600160a060020a031660009081526004602052604090208054909201909155805474ff0000000000000000000000000000000000000000191674010000000000000000000000000000000000000000179055565b600154600160a060020a031660009081526004602052604090205490565b60025474010000000000000000000000000000000000000000900460ff1690565b600254600160a060020a031660009081526004602052604090205490565b6002805473ffffffffffffffffffffffffffffffffffffffff191633179055565b6000341161029f57600080fd5b600254600160a060020a0316600090815260046020526040902080549091019055565b6001805473ffffffffffffffffffffffffffffffffffffffff191633179055565b600354600254600160a060020a0316600090815260046020526040902054101561030c57600080fd5b60038054600254600160a060020a0390811660009081526004602052604080822080549490940390935592546001549091168352912080549091019055565b600254600160a060020a0316331461036257600080fd5b6002805474ffffffffffffffffffffffffffffffffffffffffff19169055565b600154600160a060020a0316331461039957600080fd5b6001805473ffffffffffffffffffffffffffffffffffffffff191690555600a165627a7a7230582055f82a1d52dd099e6cd185bac73786cd96f164729f7cdf344387e7c5a9d196df0029";

    public static final String FUNC_CREATE = "Create";

    public static final String FUNC_TOKENSSELLER = "TokensSeller";

    public static final String FUNC_ISACTIVE = "IsActive";

    public static final String FUNC_TOKENSBUYER = "TokensBuyer";

    public static final String FUNC_BUY = "Buy";

    public static final String FUNC_ADDDEPOSIT = "AddDeposit";

    public static final String FUNC_SELL = "Sell";

    public static final String FUNC_STEP = "Step";

    public static final String FUNC_STOP = "Stop";

    public static final String FUNC_TAKEMONEY = "TakeMoney";

    protected Exchange(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Exchange(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> Create(BigInteger token, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_CREATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(token)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<BigInteger> TokensSeller() {
        final Function function = new Function(FUNC_TOKENSSELLER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Boolean> IsActive() {
        final Function function = new Function(FUNC_ISACTIVE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<BigInteger> TokensBuyer() {
        final Function function = new Function(FUNC_TOKENSBUYER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> Buy() {
        final Function function = new Function(
                FUNC_BUY, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> AddDeposit(BigInteger token, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_ADDDEPOSIT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(token)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> Sell() {
        final Function function = new Function(
                FUNC_SELL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> Step() {
        final Function function = new Function(
                FUNC_STEP, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> Stop() {
        final Function function = new Function(
                FUNC_STOP, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> TakeMoney() {
        final Function function = new Function(
                FUNC_TAKEMONEY, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<Exchange> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger _price) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_price)));
        return deployRemoteCall(Exchange.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<Exchange> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger _price) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_price)));
        return deployRemoteCall(Exchange.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static Exchange load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Exchange(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Exchange load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Exchange(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
