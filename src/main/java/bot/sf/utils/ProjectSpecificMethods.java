package bot.sf.utils;

import org.openqa.selenium.interactions.Actions;

import bot.sf.base.BaseSF;

public class ProjectSpecificMethods extends BaseSF {

	public Actions builder;

	public Actions getBuilder() {

		return builder = new Actions(getDriver());

	}

}
