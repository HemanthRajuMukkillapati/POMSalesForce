package bot.sf.testcases;


import org.testng.annotations.Test;

import bot.sf.base.BaseSF;
import bot.sf.pages.LoginSF;

public class LoginPG extends BaseSF {

	@Test
	public void runlogin() {
		new LoginSF().enterCreditianls();

	}

}
