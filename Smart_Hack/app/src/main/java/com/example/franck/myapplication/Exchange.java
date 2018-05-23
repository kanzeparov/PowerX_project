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
    private static final String BINARY = "608060405234801561001057600080fd5b50604051602080610419833981016040525160018054600160a060020a031916905560028054600160a860020a03191690556003556103c5806100546000396000f3006080604052600436106100985763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416630e62578b811461009d578063304dd754146100c45780637da1f6bf146100ed578063974c86b514610102578063a714c2c414610119578063aea90cb814610124578063b43261f314610139578063bedf0f4a1461014e578063fa57e4c714610163575b600080fd5b3480156100a957600080fd5b506100b2610178565b60408051918252519081900360200190f35b3480156100d057600080fd5b506100d96101a3565b604080519115158252519081900360200190f35b3480156100f957600080fd5b506100b26101c4565b34801561010e57600080fd5b506101176101ef565b005b610117600435610265565b34801561013057600080fd5b5061011761027d565b34801561014557600080fd5b5061011761029e565b34801561015a57600080fd5b50610117610349565b34801561016f57600080fd5b506100b2610386565b60015473ffffffffffffffffffffffffffffffffffffffff1660009081526004602052604090205490565b60025474010000000000000000000000000000000000000000900460ff1690565b60025473ffffffffffffffffffffffffffffffffffffffff1660009081526004602052604090205490565b60015473ffffffffffffffffffffffffffffffffffffffff16151561021357600080fd5b6002805474ff00000000000000000000000000000000000000001973ffffffffffffffffffffffffffffffffffffffff1990911633171674010000000000000000000000000000000000000000179055565b33600090815260046020526040902080549091019055565b6001805473ffffffffffffffffffffffffffffffffffffffff191633179055565b60035460025473ffffffffffffffffffffffffffffffffffffffff1660009081526004602052604090205410156102d457600080fd5b60025474010000000000000000000000000000000000000000900460ff1615156102fd57600080fd5b6003805460025473ffffffffffffffffffffffffffffffffffffffff90811660009081526004602052604080822080549490940390935592546001549091168352912080549091019055565b6002805474ffffffffffffffffffffffffffffffffffffffffff191690556001805473ffffffffffffffffffffffffffffffffffffffff19169055565b33600090815260046020526040902054905600a165627a7a7230582031c7da694e8412ca0e3f6fe8b1cd941f2d84fce65e7f725053ec8c4921a48edf0029";

    public static final String FUNC_TOKENSSELLER = "TokensSeller";

    public static final String FUNC_ISACTIVE = "IsActive";

    public static final String FUNC_TOKENSBUYER = "TokensBuyer";

    public static final String FUNC_BUY = "Buy";

    public static final String FUNC_ADDDEPOSIT = "AddDeposit";

    public static final String FUNC_SELL = "Sell";

    public static final String FUNC_STEP = "Step";

    public static final String FUNC_STOP = "Stop";

    public static final String FUNC_MYTOKENS = "MyTokens";

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

    public RemoteCall<BigInteger> MyTokens() {
        final Function function = new Function(FUNC_MYTOKENS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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
