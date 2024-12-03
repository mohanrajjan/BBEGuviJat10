package org.test.comp;

import org.base.com.EngineClass;
import org.pages.com.BottomLinksPage;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class BottomLinks extends EngineClass{

	@Test
	public void tc01() {
		test=report.createTest("Bottom links in homepage");
		BottomLinksPage bp= new BottomLinksPage();
		bp.giftcardbottom();
		bp.returnExchange();
		bp.contactus();
		test.log(Status.PASS, "Bottom links are validated successfully");
		
	}
}
