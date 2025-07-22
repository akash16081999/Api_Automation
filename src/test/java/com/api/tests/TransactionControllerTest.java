package com.api.tests;

import com.api.models.request.payloads.LoginReqPayload;
import com.api.models.request.payloads.TransactionControllerReqPayload;
import com.api.models.response.payloads.LoginResPayload;
import com.api.models.response.payloads.TransactionControllerResPayload;
import com.api.services.AuthService;
import com.api.services.TransactionsController;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TransactionControllerTest {

    @Test
    public void validateDepositStatusCode() {

        AuthService service = new AuthService();
        Response res = service.loginRequest(new LoginReqPayload("ak_16081999", "test@123"));
        LoginResPayload login = res.getBody().as(LoginResPayload.class);

        TransactionsController tc = new TransactionsController();
        res = tc.deposit(new TransactionControllerReqPayload.Builder().setAccountNumber("3085087902").setAmount(5000).setDescription("5000 DEPOSITED").setToAccount(" ").setFromAccount(" ").build(), login.getToken());
        TransactionControllerResPayload tr = res.getBody().as(TransactionControllerResPayload.class);
        System.out.println(tr.getBalanceAfterTransaction());
        Assert.assertEquals(res.getStatusCode(), 200);
    }


    @Test
    public void validateTransactionHistoryStatusCode() {
        AuthService service = new AuthService();
        Response res = service.loginRequest(new LoginReqPayload("ak_16081999", "test@123"));
        LoginResPayload login = res.getBody().as(LoginResPayload.class);

        TransactionsController tc = new TransactionsController();
        res = tc.getTransactionHistory(login.getToken());

        TransactionControllerResPayload trp = res.getBody().as(TransactionControllerResPayload.class);
        // System.out.println(login.getToken());
        //  trp.setPage(new TransactionControllerResPayload.Page());
        //  TransactionControllerResPayload.Page pg =trp.getPage();

        Assert.assertEquals(res.getStatusCode(), 200);
    }

    @Test
    public void validateAvailableBalanaceAfterAmountDeposited() {
        // login and fetch the token on first api call
        AuthService service = new AuthService();
        Response res = service.loginRequest(new LoginReqPayload("ak_16081999", "test@123"));
        LoginResPayload login = res.getBody().as(LoginResPayload.class);


        // call the transaction history api and fetch the available balance amount
        TransactionsController tc = new TransactionsController();
        res = tc.getTransactionHistory(login.getToken());

        TransactionControllerResPayload tranactionHistoryResponse = res.getBody().as(TransactionControllerResPayload.class);

        //  trp.setPage(new TransactionControllerResPayload.Page());
        //  TransactionControllerResPayload.Page pg =trp.getPage();


        // fetch the last updated balance amount.
        List<TransactionControllerResPayload> list = tranactionHistoryResponse.getContent();
        TransactionControllerResPayload trs = list.get(list.size() - 1);


        // call the deposit api and validate the available amount after deposit
        double deposit = 500.10;
        res = tc.deposit(new TransactionControllerReqPayload.Builder().setAccountNumber("3085087902").setAmount(deposit).setDescription(deposit + " : DEPOSITED").setToAccount(" ").setFromAccount(" ").build(), login.getToken());
        TransactionControllerResPayload tr = res.getBody().as(TransactionControllerResPayload.class);


        Assert.assertEquals(tr.getBalanceAfterTransaction(), trs.getBalanceAfterTransaction() + deposit);
    }

    @Test
    public void validateTransferApiRequestStatusCode() {

        // login and fetch the token on first api call
        AuthService service = new AuthService();
        Response res = service.loginRequest(new LoginReqPayload("ak_16081999", "test@123"));
        LoginResPayload login = res.getBody().as(LoginResPayload.class);

        // transfer the amount and check the status code.
        TransactionsController tc = new TransactionsController();
        res = tc.transfer(new TransactionControllerReqPayload.Builder().setFromAccount("3085087902").setToAccount("3195000870").setAmount(100).setDescription("amount transfering").build(), login.getToken());
        Assert.assertEquals(res.getStatusCode(), 200);


    }


    @Test
    public void validateTransferApiResponseBody() {
        // login and fetch the token on first api call
        AuthService service = new AuthService();
        Response res = service.loginRequest(new LoginReqPayload("ak_16081999", "test@123"));
        LoginResPayload login = res.getBody().as(LoginResPayload.class);

        // fetch the available amount before transferring for validation after transfer
        TransactionsController tc = new TransactionsController();
        res = tc.getTransactionHistory(login.getToken());

        TransactionControllerResPayload tranactionHistoryResponse = res.getBody().as(TransactionControllerResPayload.class);
        // fetch the last updated balance amount.
        List<TransactionControllerResPayload> list = tranactionHistoryResponse.getContent();
        TransactionControllerResPayload trs = list.get(list.size() - 1);


        // transfer amount and validating the reponse body parameters.
        res = tc.transfer(new TransactionControllerReqPayload.Builder().setFromAccount("3085087902").setToAccount("3195000870").setAmount(100).setDescription("amount transfering").build(), login.getToken());
        TransactionControllerResPayload transactionResponse = res.getBody().as(TransactionControllerResPayload.class);
        Assert.assertEquals(transactionResponse.getSourceAccount(), "3085087902");
        Assert.assertEquals(transactionResponse.getTargetAccount(), "3195000870");
        Assert.assertEquals(transactionResponse.getAmount(), 100);
        Assert.assertEquals(transactionResponse.getBalanceAfterTransaction(), trs.getBalanceAfterTransaction() - 100);
        Assert.assertEquals(transactionResponse.getType(), "TRANSFER_OUT");
        Assert.assertEquals(transactionResponse.getStatus(), "SUCCESS");
        Assert.assertEquals(transactionResponse.getDescription(), "amount transfering");

    }

    @Test
    public void validateWithdrawRequestStatusCode() {
// login and fetch the token on first api call
        AuthService service = new AuthService();
        Response res = service.loginRequest(new LoginReqPayload("ak_16081999", "test@123"));
        LoginResPayload login = res.getBody().as(LoginResPayload.class);

        TransactionsController tc = new TransactionsController();
        res = tc.Withdraw(new TransactionControllerReqPayload.Builder().setAccountNumber("3085087902").setAmount(500).setDescription("withdraw 500").build(), login.getToken());
        Assert.assertEquals(res.getStatusCode(), 200);

    }

    @Test
    public void validateTheBalanaceAmountAfterWithdraw() {

        AuthService service = new AuthService();
        Response res = service.loginRequest(new LoginReqPayload("ak_16081999", "test@123"));
        LoginResPayload login = res.getBody().as(LoginResPayload.class);
        TransactionsController tc = new TransactionsController();

        res = tc.getTransactionHistory(login.getToken());

        TransactionControllerResPayload tranactionHistoryResponse = res.getBody().as(TransactionControllerResPayload.class);
        // fetch the last updated balance amount.
        List<TransactionControllerResPayload> list = tranactionHistoryResponse.getContent();
        TransactionControllerResPayload trs = list.get(list.size() - 1);

        // withdraw api is called and now validate with the history api data.
        res = tc.Withdraw(new TransactionControllerReqPayload.Builder().setAccountNumber("3085087902").setAmount(100).setDescription("withdraw 100").build(), login.getToken());
        TransactionControllerResPayload transactionConrollerResponse = res.getBody().as(TransactionControllerResPayload.class);
        Assert.assertEquals(transactionConrollerResponse.getBalanceAfterTransaction(), trs.getBalanceAfterTransaction() - 100);

    }

}





