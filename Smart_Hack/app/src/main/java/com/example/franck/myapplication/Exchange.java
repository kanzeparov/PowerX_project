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
    private static final String BINARY = "608060405234801561001057600080fd5b506040516020806103e2833981016040525160018054600160a060020a031916905560028054600160a860020a031916905560035561038e806100546000396000f30060806040526004361061008d5763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416630e62578b8114610092578063304dd754146100b95780637da1f6bf146100e2578063974c86b5146100f7578063a714c2c41461010e578063aea90cb814610119578063b43261f31461012e578063bedf0f4a14610143575b600080fd5b34801561009e57600080fd5b506100a7610158565b60408051918252519081900360200190f35b3480156100c557600080fd5b506100ce610183565b604080519115158252519081900360200190f35b3480156100ee57600080fd5b506100a76101a4565b34801561010357600080fd5b5061010c6101cf565b005b61010c600435610245565b34801561012557600080fd5b5061010c610282565b34801561013a57600080fd5b5061010c6102a3565b34801561014f57600080fd5b5061010c610325565b60015473ffffffffffffffffffffffffffffffffffffffff1660009081526004602052604090205490565b60025474010000000000000000000000000000000000000000900460ff1690565b60025473ffffffffffffffffffffffffffffffffffffffff1660009081526004602052604090205490565b60015473ffffffffffffffffffffffffffffffffffffffff1615156101f357600080fd5b6002805474ff00000000000000000000000000000000000000001973ffffffffffffffffffffffffffffffffffffffff1990911633171674010000000000000000000000000000000000000000179055565b6000341161025257600080fd5b60025473ffffffffffffffffffffffffffffffffffffffff16600090815260046020526040902080549091019055565b6001805473ffffffffffffffffffffffffffffffffffffffff191633179055565b60035460025473ffffffffffffffffffffffffffffffffffffffff1660009081526004602052604090205410156102d957600080fd5b6003805460025473ffffffffffffffffffffffffffffffffffffffff90811660009081526004602052604080822080549490940390935592546001549091168352912080549091019055565b6002805474ffffffffffffffffffffffffffffffffffffffffff191690556001805473ffffffffffffffffffffffffffffffffffffffff191690555600a165627a7a72305820c6b3ccd394a22d6efd07a0309acd6da3d83ab2ee4468be3c34b42b167a358ef40029";

    public static final String FUNC_TOKENSSELLER = "TokensSeller";

    public static final String FUNC_ISACTIVE = "IsActive";

    public static final String FUNC_TOKENSBUYER = "TokensBuyer";

    public static final String FUNC_BUY = "Buy";

    public static final String FUNC_ADDDEPOSIT = "AddDeposit";

    public static final String FUNC_SELL = "Sell";

    public static final String FUNC_STEP = "Step";

    public static final String FUNC_STOP = "Stop";

    protected Exchange(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Exchange(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
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
