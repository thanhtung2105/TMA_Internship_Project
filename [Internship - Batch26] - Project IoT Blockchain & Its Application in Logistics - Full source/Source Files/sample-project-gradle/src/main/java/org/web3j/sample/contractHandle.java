package org.web3j.sample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.sample.contracts.generated.Products_manager;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import java.math.BigInteger;

public class contractHandle {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    // Trên rinkeby chain có nhiều smart contract được implement, CONTRACT_ADDRESS để xác định smartcontract của t
    private final String CONTRACT_ADDRESS = "0x55b2900b87b2eda7e3cbe61af513d737f4980106";
    // Địa chỉ ACCOUNT0 và PRIVATE_KEY0 để xác định tài khoản và ví để trả phí cho các giao dich (gas_prices)
    private final String ACCOUNT0 = "0x13f4d28863c5Cd9f53E0c4F8f6CaD3C921b648fc";
    private final String PRIVATE_KEY0 = "0x9CAD73E956F9304D5392E27411B3F4B1C8C590B71DE495DC53AD6D77F68DCC1A";
    // điều hướng truy cập đến infura server, thông qua đó một máy tính không phải là ethernode vẫn có thể truy cập chain
    Web3j web3j = Web3j.build(new HttpService("https://rinkeby.infura.io/v3/22e36e35c19148adbdd7d769761f0259"));

    // tạo ví từ private key
    Credentials credentials = Credentials.create(PRIVATE_KEY0);
    ContractGasProvider contractGasProvider = new DefaultGasProvider();

    public void inputInfo(BigInteger barcode, String name, String origin, String quality) throws Exception {
        log.info("Connected to Ethereum client version: "
                + web3j.web3ClientVersion().send().getWeb3ClientVersion());

        //tạo một smartcontract từ những thông tin bên trên, bây giờ ta đã có thể tương tác với smartcontract
        Products_manager contract = Products_manager.load(CONTRACT_ADDRESS, web3j, credentials,
                contractGasProvider);
        TransactionReceipt inputInfor_result = contract.inputInfo(barcode, name, origin, quality).send();
        log.info(inputInfor_result.toString());
    }
}
