package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.LoginPage;

public class InvalidLogin extends BaseTest
{
	@Test(priority = 2)
	public void testInvalidLogin()
	{
		String un=Excel.getCellData(XL_PATH,"InvalidLogin",1,0);
		String pw=Excel.getCellData(XL_PATH,"InvalidLogin",1,1);
//		1. enter invalid un
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserName(un);
//		2. enter invalid pw
		loginPage.setPassword(pw);
//		3. click login button
		loginPage.clickLoginButton();
//		4. Err msg should be displayed
		boolean result = loginPage.verifyErrMsgIsDisplayed(wait);
		Assert.assertTrue(result);
	}
}
