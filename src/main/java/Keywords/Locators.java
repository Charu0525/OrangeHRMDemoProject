package Keywords;


	public interface Locators {
		//Interface is created as the variables are static and final.and are written in capital letters
		String USERNAME="//input[@placeholder='Username']";
		String PASSWORD="//input[@name='password']";
		String LOGIN="//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']";
		String USERNAMEERRMSG="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']";
		String PASSWORDERRMSG="//span[@css='1']";
		String URL="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		String DASHBOARD="//h6[text()='Dashboard']";
		String MYINFO="//span[text()='My Info']";
		String PERSONDETAILS="//a[text()='Personal Details']";
		String ADDEMP="(//div[@class='oxd-topbar-body-nav-slot'])[1]";
		String EMPFNAME="//input[@name=\'firstName']";
		String EMPLNAME="//input[@name='lastName']";
		String SAVE="//button[@type='submit']";
		String LEAVETAB="//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']";
		String EMPLEAVE="//div[@class='oxd-table']";
		String OPTIONS="//i[@with-container='false']";
		String VIEWLEAVEDETAILS="//p[text()='View Leave Details']";
		
		
		
		
	


}
