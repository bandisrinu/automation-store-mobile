package com.classplusapp.web.pages;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BFindBys;
import com.b2b.support.B2BPageFactory;
import com.classplusapp.base.page.ClassplusappBasePage;

public class ContentPage extends ClassplusappBasePage {
	private static final Logger log = LogManager.getLogger(ContentPage.class);

	@B2BFindBy(xpath = "{btnAddImage}")
	private WebElement btnAddImage;

	@B2BFindBy(xpath = "{txtImageName}")
	private WebElement txtImageName;

	@B2BFindBy(xpath = "{txtDescription}")
	private WebElement txtDescription;

	@B2BFindBy(xpath = "{btnSelectImage}")
	private WebElement btnSelectImage;

	@B2BFindBy(xpath = "{btnUploadImage}")
	private WebElement btnUploadImage;

	@B2BFindBy(xpath = "{btnAddFolder}")
	private WebElement btnAddFolder;

	@B2BFindBy(xpath = "{txtFolderName}")
	private WebElement txtFolderName;

	@B2BFindBy(xpath = "{btnFolderSave}")
	private WebElement btnFolderSave;

	@B2BFindBy(xpath = "{btnAddDocument}")
	private WebElement btnAddDocument;

	@B2BFindBy(xpath = "{lblAddDocumentText}")
	private WebElement lblAddDocumentText;

	@B2BFindBy(xpath = "{txtDocumentName}")
	private WebElement txtDocumentName;

	@B2BFindBy(xpath = "{btnSelectDocument}")
	private WebElement btnSelectDocument;

	@B2BFindBy(xpath = "{btnUploadDocument}")
	private WebElement btnUploadDocument;

	@B2BFindBy(xpath = "{btnAddVideo}")
	private WebElement btnAddVideo;

	@B2BFindBy(xpath = "{btnUploadVideo}")
	private WebElement btnUploadVideo;

	@B2BFindBy(xpath = "{inputSend}")
	private WebElement inputSend;

	@B2BFindBy(xpath = "{lblAddVideo}")
	private WebElement lblAddVideo;

	@B2BFindBy(xpath = "{btnVideoUploadDone}")
	private WebElement btnVideoUploadDone;

	@B2BFindBy(xpath = "{inpZipName}")
	private WebElement inpZipName;

	@B2BFindBy(xpath = "{btnAddZipFile}")
	private WebElement btnAddZipFile;

	@B2BFindBy(xpath = "{msgFileUploadedZip}")
	private WebElement msgFileUploadedZip;

	@B2BFindBy(xpath = "{inpZipDescription}")
	private WebElement inpZipDescription;

	@B2BFindBy(xpath = "{btnSelectZipFile}")
	private WebElement btnSelectZipFile;

	@B2BFindBy(xpath = "{btnUploadZipFile}")
	private WebElement btnUploadZipFile;

	@B2BFindBy(xpath = "{titleCourseName}")
	private WebElement titleCourseName;

	@B2BFindBy(xpath = "{mnuSubjectiveTestIcon}")
	private WebElement mnuSubjectiveTestIcon;

	@B2BFindBy(xpath = "{lblSubjectiveTest}")
	private WebElement lblSubjectiveTest;

	@B2BFindBy(xpath = "{btnCreateNewSubjTest}")
	private WebElement btnCreateNewSubjTest;

	@B2BFindBy(xpath = "{lblCreateNewSubjectiveTest}")
	private WebElement lblCreateNewSubjectiveTest;

	@B2BFindBy(xpath = "{txtSubjName}")
	private WebElement txtSubjName;

	@B2BFindBy(xpath = "{txtTotalSubjMarks}")
	private WebElement txtTotalSubjMarks;

	@B2BFindBy(xpath = "{btnAddFiles}")
	private WebElement btnAddFiles;

	@B2BFindBy(xpath = "{msgFileUploadedSubjText}")
	private WebElement msgFileUploadedSubjText;

	@B2BFindBy(xpath = "{btnCreateAndAddSubjTest}")
	private WebElement btnCreateAndAddSubjTest;

	@B2BFindBy(xpath = "{btnUnLoctContent}")
	private WebElement btnUnLockContent;

	@B2BFindBy(xpath = "{btnSave}")
	private WebElement btnSave;

	@B2BFindBy(xpath = "{btnEditMenu}")
	private WebElement btnEditMenu;

	@B2BFindBy(xpath = "{mnuVerticalIcon}")
	private WebElement mnuVerticalIcon;

	@B2BFindBy(xpath = "{msgEditFolder}")
	private WebElement msgEditFolder;

	@B2BFindBy(xpath = "{lblEditContent}")
	private WebElement lblEditContent;

	@B2BFindBy(xpath = "{txtEditFileName}")
	private WebElement txtEditFileName;

	@B2BFindBy(xpath = "{lblAddZip}")
	private WebElement lblAddZip;

	@B2BFindBy(xpath = "{btnRemoveFile}")
	private WebElement btnRemoveFile;

	@B2BFindBy(xpath = "{msgDeletedSuccesfullText}")
	private WebElement msgDeletedSuccesfullText;

	@B2BFindBys(@B2BFindBy(xpath = "{lblAddedContent}"))
	private List<WebElement> lblAddedContent;

	@B2BFindBy(xpath = "{btnDiscard}")
	private WebElement btnDiscard;

	@B2BFindBy(xpath = "{btnSubjectiveTest}")
	private WebElement btnSubjectiveTest;

	@B2BFindBy(xpath = "{btnAddSubjectiveTest}")
	private WebElement btnAddSubjectiveTest;

	@B2BFindBy(xpath = "{btnAddTest}")
	private WebElement btnAddTest;

	@B2BFindBy(xpath = "{titleSuccessToastMsg}")
	private WebElement titleSuccessToastMsg;

	@B2BFindBy(xpath = "{btnDeletedFile}")
	private WebElement btnDeletedFile;

	@B2BFindBy(xpath = "{lblReorderIcon}")
	private WebElement lblReorderIcon;

	@B2BFindBy(xpath = "{chkContent}")
	private WebElement chkContent;

	@B2BFindBy(xpath = "{txtToastMsg}")
	private WebElement txtToastMsg;

	@B2BFindBy(xpath = "{txtGetFolderName}")
	private WebElement txtGetFolderName;

	@B2BFindBy(xpath = "{lblSavedFolder}")
	private WebElement lblSavedFolder;

	@B2BFindBy(xpath = "{lblAddedContent}")
	private WebElement lblAddedFolderContent;

	@B2BFindBy(xpath = "{lblSavedZipFolder}")
	private WebElement lblSavedZipFolder;

	@B2BFindBy(xpath = "{btnViewStats}")
	private WebElement btnViewStats;

	@B2BFindBy(xpath = "{btnPreview}")
	private WebElement btnPreview;

	@B2BFindBy(xpath = "{msgTestStats}")
	private WebElement msgTestStats;

	@B2BFindBy(xpath = "{noStatsLabel}")
	private WebElement noStatsLabel;

	@B2BFindBy(xpath = "{noStudentAttemptedLabel}")
	private WebElement noStudentAttemptedLabel;

	@B2BFindBy(xpath = "{txtSearchSubjectiveTest}")
	private WebElement txtSearchSubjectiveTest;

	@B2BFindBy(xpath = "{lblNoTestFound}")
	private WebElement lblNoTestFound;

	@B2BFindBy(xpath = "{uploadPercent}")
	private WebElement uploadPercent;

	@B2BFindBy(xpath = "{mnuImportContentIcon}")
	private WebElement mnuImportContentIcon;

	@B2BFindBy(xpath = "{lblImportContent}")
	private WebElement lblImportContent;

	@B2BFindBy(xpath = "{lblImportLive}")
	private WebElement lblImportLive;

	@B2BFindBy(xpath = "{chkImportContent}")
	private WebElement chkImportContent;

	@B2BFindBy(xpath = "{btnImportSelected}")
	private WebElement btnImportSelected;

	@B2BFindBy(xpath = "{mnuImportLiveIcon}")
	private WebElement mnuImportLiveIcon;

	@B2BFindBy(xpath = "{lblVideoIcon}")
	private WebElement lblVideoIcon;

	@B2BFindBy(xpath = "{lblContentCannotViewed}")
	private WebElement lblContentCannotViewed;

	@B2BFindBy(xpath = "{imgSample}")
	private WebElement imgSample;

	@B2BFindBy(xpath = "{lblContentCannotViewedOnWeb}")
	private WebElement lblContentCannotViewedOnWeb;

	@B2BFindBy(xpath = "{mnuFiles}")
	private WebElement mnuFiles;

	@B2BFindBy(xpath = "{lblAttemptTest}")
	private WebElement lblAttemptTest;

	@B2BFindBy(xpath = "{lblLockIcon}")
	private WebElement lblLockIcon;

	@B2BFindBy(xpath = "{btnUnlock}")
	private WebElement btnUnlock;

	@B2BFindBy(xpath = "{btnLock}")
	private WebElement btnLock;

	@B2BFindBys(@B2BFindBy(xpath = "{lstAddedContent}"))
	private List<WebElement> lstAddedContent;

	@B2BFindBy(xpath = "{lblBuyNow}")
	private WebElement lblBuyNow;

	@B2BFindBys({ @B2BFindBy(xpath = "{draggableImages}") })
	private List<WebElement> draggableImages;

	@B2BFindBy(xpath = "{titleSameNameMsg}")
	private WebElement titleSameNameMsg;

	@B2BFindBy(xpath = "{msgContentEdit}")
	private WebElement msgContentEdit;

	@B2BFindBy(xpath = "{msginValidSubjectiveTest}")
	private WebElement msginValidSubjectiveTest;

	@B2BFindBy(xpath = "{toastMessageTitle}")
	private WebElement toastMessageTitle;
	
	@B2BFindBy(xpath = "{btnDiscardEditContent}")
	private WebElement btnDiscardEditContent;
	
	@B2BFindBy(xpath = "{btnCloseContentPage}")
	private WebElement btnCloseContentPage;
	
	@B2BFindBy(xpath = "{addOrEditContentWindow}")
	private WebElement addOrEditContentWindow;
	
	public ContentPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void clickOnAddImageButton() {

		log.info("starting of clickOnAddImageButton  method");

		try {
			this.explicitWait(btnAddImage);
			btnAddImage.click();
			log.info("ending of clickOnAddImageButton  method");
		} catch (Exception e) {
			this.explicitWait(btnAddImage);
			this.clickOnWebElement(btnAddImage);
		}
	}

	public void setImageName(String imgName) {
		log.info("starting of setImageName  method");
		txtImageName.clear();
		txtImageName.sendKeys(imgName);

		log.info("ending of setImageName  method");
	}
	
	public void clearImageName() {
		log.info("starting of clearImageName  method");
//		txtImageName.click();
//		txtImageName.clear();
//		JavascriptExecutor j = (JavascriptExecutor) driver;
//		
//		j.executeScript("arguments[0].setAttribute('value', '')",txtImageName);
		while(!txtImageName.getAttribute("value").equals(""))
		txtImageName.sendKeys(Keys.BACK_SPACE);
		//j.executeScript("document.getElementsByClassName('heading')[0].setAttribute('style', 'background-color: red')");
		//txtImageName.clear();
		log.info("ending of clearImageName  method");
	}

	public void setImageDescription(String imgDescription) {
		log.info("starting of setImageDescription  method");
		txtDescription.clear();
		txtDescription.sendKeys(imgDescription);
		log.info("ending of setImageDescription  method");
	}

	public void clickOnUploadImageButton(String uploadimage) {

		hardWait(2);
		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			btnSelectImage.sendKeys(TEST_FILE_PATH + "/testdata/" + uploadimage);
		} else {
			hardWait(5);
			System.out.println("Image path:::"+ TEST_FILE_PATH + File.separator + "testdata" + File.separator + uploadimage);
			btnSelectImage.sendKeys(TEST_FILE_PATH + File.separator + "testdata" + File.separator + uploadimage);
		}
	}

	public void clickOnBtnUploadImageButton() {
		btnUploadImage.click();
	}

	public void clickOnAddFolderButton() {
		this.hardWait(3);
		btnAddFolder.click();
	}

	public void setFolderName(String nameFolder) {
		txtFolderName.clear();
		txtFolderName.sendKeys(nameFolder);
	}

	public void clickOnBtnFolderSave() {
		btnFolderSave.click();
	}

	public void clickOnAddDocumentButton() {
		try {
			btnAddDocument.click();
		} catch (Exception e) {
			clickOnWebElement(btnAddDocument);
		}

	}

	public String getLabelDocumentText() {
		return lblAddDocumentText.getText();
	}

	public void setDocumentName(String documentName) {
		txtDocumentName.clear();
		txtDocumentName.sendKeys(documentName);
	}
	
	public void clearDocumentName() {
		while(!txtDocumentName.getAttribute("value").equals(""))
			txtDocumentName.sendKeys(Keys.BACK_SPACE);
	}

	public void setDocumentDescription(String documentDescription) {
		txtDescription.clear();
		txtDescription.sendKeys(documentDescription);
	}

	public void clickOnSelectDocumentButton(String uploadDocument) {
		hardWait(3);
		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			btnSelectDocument.sendKeys(TEST_FILE_PATH + "/testdata/" + uploadDocument);
		} else {

			btnSelectDocument.sendKeys(TEST_FILE_PATH + File.separator + "testdata" + File.separator + uploadDocument);
			hardWait(5);

		}
	}

	public void clickOnUploadDocumentButton() {

		try {
			btnUploadDocument.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnUploadDocument);
		}

	}

	public void clickOnAddVideo() {
		btnAddVideo.click();
	}

	public String getAddVideoHeader() {
		return lblAddVideo.getText();
	}

	public void clickOnBtnUploadVideo(String uploadVideo) {
		btnUploadVideo.click();
		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			inputSend.sendKeys(TEST_FILE_PATH + "/testdata/" + uploadVideo);
		} else {
			hardWait(2);
			System.out.println("Video location::::" + TEST_FILE_PATH + File.separator + "testdata" + File.separator + uploadVideo);
			inputSend.sendKeys(TEST_FILE_PATH + File.separator + "testdata" + File.separator + uploadVideo);
		}

		hardWait(20);

	}

	/*
	 * public void uploadVideoButton(String filepath) {
	 * log.info("Starting of uploadVideoButton method");
	 * 
	 * try { this.clickOnWebElement(btnUploadVideo); Thread.sleep(1000);
	 * this.closeOSWindow(); Thread.sleep(1000); this.inputSend.sendKeys(filepath);
	 * } catch (Exception e) { }
	 * 
	 * log.info("Ending of uploadVideoButton method"); }
	 */

	public void clickOnBtnDone() {
		try {
			btnVideoUploadDone.click();
		} catch (Exception e) {
			clickOnWebElement(btnVideoUploadDone);
		}

	}

	public void clickOnAddZipFile() {
		btnAddZipFile.click();
	}

	public String getLabelAddZipText() {
		log.info("Starting of getLabelAddZipText method");

		log.info(" Ending of getLabelAddZipText method");
		return lblAddZip.getText();
	}

	public void setZipFileName(String nameZipFile) {
		inpZipName.clear();
		inpZipName.click();
		inpZipName.sendKeys(nameZipFile);

	}
	
	public void clearZipFileName() {
		while(!inpZipName.getAttribute("value").equals(""))
			inpZipName.sendKeys(Keys.BACK_SPACE);
	}

	public void setZipFileDescription(String descriptionZipFile) {
		inpZipDescription.clear();
		inpZipDescription.click();
		inpZipDescription.sendKeys(descriptionZipFile);
	}

	public void clickOnSelectZipFile(String uploadZipFile) {
		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			btnSelectZipFile.sendKeys(TEST_FILE_PATH + "/testdata/" + uploadZipFile);
		} else {

			btnSelectZipFile.sendKeys(TEST_FILE_PATH + File.separator + "testdata" + File.separator + uploadZipFile);

		}

	}

	public void clickOnUploadZipFile() {
		btnUploadZipFile.click();
	}

	public String getCourseNameInContentPage() {
		explicitWait(titleCourseName);
		return titleCourseName.getText();
	}

	public String getContentCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public void clickOnMenuSubjectiveTestIcon() {
		log.info("Starting of clickOnMenuSubjectiveTestIcon method");

		this.explicitWait(mnuSubjectiveTestIcon);
		this.clickOnWebElement(mnuSubjectiveTestIcon);

		log.info("Ending of clickOnMenuSubjectiveTestIcon method");
	}

	public String getSubjectiveTestLabel() {
		log.info("Starting of getSubjectiveTestLabel method");

		// this.explicitWait(msgDeletedSuccesfullText);

		log.info("Ending of getSubjectiveTestLabel method");
		return this.lblSubjectiveTest.getText();
	}

	public void clickOnCreateNewTestButton() {
		log.info("Starting of clickOnCreateNewTestButton method");

		try {
			hardWait(2);
			Actions actions = new Actions(driver);
			actions.click(btnCreateNewSubjTest).build().perform();
		} catch (Exception e) {
			this.clickOnWebElement(btnCreateNewSubjTest);
		}
		log.info("Ending of clickOnCreateNewTestButton method");

	}

	public String getCreateNewSubjectiveTestLabel() {
		log.info("Starting of getCreateNewSubjectiveTestLabel method");

		// this.explicitWait(msgDeletedSuccesfullText);

		log.info("Ending of getCreateNewSubjectiveTestLabel method");
		return this.lblCreateNewSubjectiveTest.getText();
	}

	public void setTextTestName(String strName) {
		log.info("Starting of setTextTestName method");

		this.txtSubjName.sendKeys(strName);

		log.info("Ending of setTextTestName method");

	}

	public void clickOnTextTotalMarks(String strName) {
		log.info("Starting of clickOnTextTotalMarks method");

		this.txtTotalSubjMarks.sendKeys(strName);

		log.info("Ending of clickOnTextTotalMarks method");

	}

	public void clickOnAddFilesButton() {
		log.info("starting of setUploadImageButton method");

		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			btnAddFiles.sendKeys(TEST_FILE_PATH + "/testdata/subjectiveTutorPdf.pdf");
		} else {

			// btnAddFiles.sendKeys(TEST_FILE_PATH + "\\testdata\\subjectiveTutorPdf.pdf");
			btnAddFiles
					.sendKeys(TEST_FILE_PATH + File.separator + "testdata" + File.separator + "subjectiveTutorPdf.pdf");
		}
		uploadImage(btnAddFiles, "subjectiveTutorPdf.pdf");

		log.info("Ending of setUploadImageButton method");
	}

	public String getSaveSubjSuccessMessage() {
		log.info("Starting of getSaveSubjSuccessMessage method");

		log.info("Ending of getSaveSubjSuccessMessage method");
		return msgFileUploadedSubjText.getText();
	}

	public void clickOnCreateAndAddTestButton() {
		log.info("Starting of clickOnCreateAndAddTestButton method");

		try {
			scrollIntoView(btnCreateAndAddSubjTest);
			Actions act = new Actions(driver);
			act.click(btnCreateAndAddSubjTest).build().perform();
		} catch (Exception e) {
			this.clickOnWebElement(btnCreateAndAddSubjTest);
		}

		log.info("Ending of clickOnCreateAndAddTestButton method");
	}

	public void clickOnUnLockContentButton() {
		btnUnLockContent.click();
	}

	public String getUnLockContentText() {
		return btnUnLockContent.getText();
	}

	public void clickOnVerticalMenuZip() {
		log.info("starting of clickOnVerticalMenuZip  method");

		if (mnuVerticalIcon.isDisplayed());
		hardWait(3);
		this.clickOnWebElement(mnuVerticalIcon);

		log.info("Ending of clickOnVerticalMenuZip method");
	}

	public void clickOnEditFileButton() {
		log.info("Starting of  clickOnEditfileButton method");

		hardWait(3);
		this.clickOnWebElement(btnEditMenu);

		log.info("Ending of clickOnEditfileButton method");
	}

	public void setEditName(String strFile) {
		log.info("Starting of setEditName method");

		this.txtEditFileName.click();
		this.txtEditFileName.clear();
		this.txtEditFileName.click();
		this.txtEditFileName.sendKeys(strFile);
		
		hardWait(2);

		log.info("Ending of setEditName method");

	}
	
	public void clearEditName() {
		log.info("Starting of clearEditName method");
		hardWait(3);
		while(!txtEditFileName.getAttribute("value").equals(""))
			txtEditFileName.sendKeys(Keys.BACK_SPACE);
		hardWait(3);

		log.info("Ending of clearEditName method");

	}

	public void setEmptyName() {
		log.info("Starting of setEmptyName method");

		this.clickOnWebElement(txtEditFileName);
		this.txtEditFileName.sendKeys(Keys.CONTROL+ "a"+ Keys.DELETE );
		this.hardWait(1);

		log.info("Ending of setEmptyName method");

	}

	public String getLabelEditContentText() {
		log.info("Starting of getLabelEditContentText method");

		log.info("Ending of getLabelEditContentText method");
		return lblEditContent.getText();
	}

	public void clickOnSaveButton() {
		btnSave.click();
	}

	public String getEditSuccessMessageText() {
		log.info("Starting of getEditSuccessMessageText method");

		this.explicitWait(msgEditFolder);

		log.info("Ending of getEditSuccessMessageText method");
		return this.msgEditFolder.getText();
	}

	public void clickOnRemoveFileButton() {
		log.info("starting of clickOnRemoveFileButton  method");

		try {
			this.clickOnWebElement(btnRemoveFile);
		} catch (Exception e) {
			Actions action = new Actions(driver);
			action.click(btnRemoveFile).build().perform();
		}
		log.info("Ending of clickOnRemoveFileButton method");
	}

	public void clickOnDeletedFileButton() {
		log.info("starting of clickOnDeletedFileButton  method");

		this.clickOnWebElement(btnDeletedFile);

		log.info("Ending of clickOnDeletedFileButton method");
	}

	public String deleteSuccessMessageText() {
		log.info("Starting of deleteZipSuccessMessageText method");

		this.explicitWait(msgDeletedSuccesfullText);

		log.info("Ending of deleteSuccessMessage method");
		return this.msgDeletedSuccesfullText.getText();
	}

	public boolean getAddedContentText(String contentName) {

		log.info("Starting of getAddedContentTexts method");
		log.info("Ending of getAddedContentTexts method");

		return getAddedContentText(lblAddedContent, contentName);
	}

	public void clickOnDiscardButton() {
		log.info("Starting of clickOnDiscardButton method");
		btnDiscard.click();
		log.info("Ending of clickOnDiscardButton method");
	} 
	
	public void clickOnCloseButton() {
		log.info("Starting of clickOnCloseButton method");
		btnCloseContentPage.click();
		log.info("Ending of clickOnCloseButton method");
	}
	
	public void clickOnEditContentDiscardButton() {
		log.info("Starting of clickOnEditContentDiscardButton method");
		btnDiscardEditContent.click();
		log.info("Ending of clickOnEditContentDiscardButton method");
	}

	public void clickOnSubjectiveTestButton() {
		log.info("Starting of clickOnSubjectiveTestButton method");

		this.explicitWait(btnSubjectiveTest);
		btnSubjectiveTest.click();

		log.info("Ending of clickOnSubjectiveTestButton method");
	}

	public void clickOnAddSubjectiveTestButton() {
		log.info("Starting of clickOnAddSubjectiveTestButton method");

		btnAddTest.click();

		log.info("Ending of clickOnAddSubjectiveTestButton method");
	}

	public String getToastMessageText() {
		explicitWait(titleSuccessToastMsg);
		return titleSuccessToastMsg.getText();
	}
	
	public String getToastMessageTitle() {
		explicitWait(toastMessageTitle);
		return toastMessageTitle.getText();
	}

	public boolean isDisplayedReorderIcon() {
		this.mouseHover(lblReorderIcon);
		lblReorderIcon.isDisplayed();
		return true;
	}

	public boolean isDisplayedCheckBox() {
		this.mouseHover(chkContent);
		chkContent.isDisplayed();
		return true;
	}

	public String getSuccessToastMessageText() {
		explicitWait(txtToastMsg);
		return txtToastMsg.getText();
	}

	public String getInValidSubjectiveTestText() {
		explicitWait(msginValidSubjectiveTest);
		return msginValidSubjectiveTest.getText();
	}

	public String getGivenFolderName() {
		return lblAddedFolderContent.getText();

	}

	public void clickOnSavedFolder() {
		lblSavedFolder.click();
	}

	public boolean isDisplayedSavedFolder() {

		this.explicitWait(lblSavedFolder);
		return lblSavedFolder.isDisplayed();
	}

	public void clickOnSavedZipFolder() {
		lblSavedZipFolder.click();
	}

	public File getDownloadedZipFolder() {

		return getLastModified();
	}

	public boolean isDisplayedViewStatsButton() {
		log.info("starting of isDisplayedViewStatsButton method");
		log.info("Ending of isDisplayedViewStatsButton method");

		return btnViewStats.isDisplayed();
	}

	public boolean isDisplayedPreviewButton() {
		log.info("starting of isDisplayedPreviewButton method");
		log.info("Ending of isDisplayedPreviewButton method");

		return btnPreview.isDisplayed();
	}

	public void clickOnEnablePreview() {
		log.info("starting of clickOnEnablePreview method");
		try {
			hardWait(3);
			if(btnPreview.isDisplayed())
				btnPreview.click();
		} catch(Exception e) {
			this.refresh();
		}
		
		log.info("Ending of clickOnEnablePreview method");
	}

	public void clickOnViewStatsButton() {
		log.info("starting of clickOnViewStatsButton method");

		try {
			this.btnViewStats.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnViewStats);
		}

		log.info("Ending of clickOnViewStatsButton method");
	}

	public String getTestStatsHeader() {
		log.info("Starting of getTestStatsHeader method");
		log.info("Ending of getTestStatsHeader method");

		return msgTestStats.getText();
	}

	public String getNoStatsLabel() {
		log.info("Starting of getNoStatsLabel method");
		log.info("Ending of getNoStatsLabel method");

		return noStatsLabel.getText();
	}

	public String getNoStudentLabel() {
		log.info("Starting of getNoStudentLabel method");
		log.info("Ending of getNoStudentLabel method");

		return noStudentAttemptedLabel.getText();
	}

	public void setSearchSubjectiveTest(String strSearchSubjectiveTest) {
		log.info("Starting of setFolderName method");

		this.explicitWait(txtSearchSubjectiveTest);
		txtSearchSubjectiveTest.clear();
		txtSearchSubjectiveTest.sendKeys(strSearchSubjectiveTest);

		log.info("Ending of setFolderName method");
	}

	public String getNoTestFoundLabel() {
		log.info("Starting of getNoTestFoundLabel method");
		log.info("Ending of getNoTestFoundLabel method");

		return lblNoTestFound.getText();

	}

	public void clickOnAddCourseButton() {
		log.info("Starting of removeCourseButton method");

		this.clickOnWebElement(btnAddSubjectiveTest);

		log.info("Ending of removeCourseButton method");
	}

	public void clickOnMaxAddFilesButton() throws Exception {
		log.info("starting of clickOnMaxAddFilesButton method");

		hardWait(2);
		for (int i = 0; i < 5; i++) {
			uploadImage(btnAddFiles, "sampleSubjPdf.pdf");
		}

		log.info("Ending of clickOnMaxAddFilesButton method");
	}

	public void getTimeout() {
		while (true) {
			String upload = this.uploadPercent.getText().replace("%", "");
			int percent = Integer.parseInt(upload);
			// System.out.println(percent);
			if (percent > 90)
				break;
		}
	}

	public void clickOnUploadInvalidPdf() throws InterruptedException {
		log.info("starting of clickOnUploadInvalidPdf method");

		uploadImage(btnAddFiles, "invalidSubjTest.pdf");

		log.info("Ending of clickOnUploadInvalidPdf method");
	}

	public void clickOnMenuImportContentIcon() {
		log.info("Starting of clickOnMenuImportContentIcon method");

		this.clickOnWebElement(mnuImportContentIcon);

		log.info("Ending of clickOnMenuImportContentIcon method");
	}

	public String getlabelImportContentText() {
		log.info("Starting of getlabelImportContentText method");
		log.info("Ending of getlabelImportContentText method");

		return lblImportContent.getText();
	}

	public String getlabelImportLiveText() {
		log.info("Starting of getlabelImportLiveText method");
		log.info("Ending of getlabelImportLiveText method");

		return lblImportLive.getText();
	}

	public void clickOnImportCheckBox() {
		log.info("Starting of clickOnImportCheckBox method");

		this.clickOnWebElement(chkImportContent);

		log.info("Ending of clickOnImportCheckBox method");
	}

	public void clickOnImportSelectedButton() {
		log.info("Starting of clickOnImportSelectedButton method");

		this.btnImportSelected.click();

		log.info("Ending of clickOnImportSelectedButton method");
	}

	public void clickOnMenuImportLiveIcon() {
		log.info("Starting of clickOnMenuImportContentIcon method");

		this.clickOnWebElement(mnuImportLiveIcon);

		log.info("Ending of clickOnMenuImportContentIcon method");
	}

	public void clickOnVideoTest() {
		log.info("Starting of clickOnVideoTest method");

		this.hardWait(2);
		try {
			this.clickOnWebElement(lblVideoIcon);
		} catch (Exception e) {
			this.lblVideoIcon.click();
		}

		log.info("Ending of clickOnVideoTest method");
	}

	public String getContentCannotViewedLabel() {
		log.info("Starting of getContentCannontViewedLabel method");
		log.info(" Ending of getContentCannontViewedLabel method");

		return lblContentCannotViewed.getText();
	}

	public void clickOnSampleImage() {
		log.info("starting of clickOnSampleImage  method");

		this.clickOnWebElement(imgSample);

		log.info("Ending of clickOnSampleImage method");
	}

	public String getContentCannotViewedLabelonWeb() {
		log.info("Starting of getContentCannotViewedLabelonWeb method");
		log.info(" Ending of getContentCannotViewedLabelonWeb method");

		return lblContentCannotViewedOnWeb.getText();
	}

	public void clickOnFilesMenu() {
		log.info("Starting of clickOnFilesMenu method");

		this.explicitWait(mnuFiles);
		try {
			this.hardWait(2);
			this.clickOnWebElement(mnuFiles);
		} catch (Exception e) {
			this.mnuFiles.click();
		}

		log.info("Ending of clickOnFilesMenu method");
	}

	public String getAttemptTest() {
		log.info("Starting of getAttemptTest method");
		log.info("Ending of getAttemptTest method");

		return lblAttemptTest.getText();
	}

	public void clickOnLockIcon() {
		log.info("Starting of clickOnLockIcon method");

		try {
			this.hardWait(4);
			this.lblLockIcon.click();
		} catch (Exception e) {
			this.clickOnWebElement(lblLockIcon);
		}

		log.info("Ending of clickOnLockIcon method");
	}

	public void clickOnUnLockIcon() {
		log.info("Starting of clickOnUnLockIcon method");

		try {
			this.hardWait(1);
			this.lblLockIcon.click();
		} catch (Exception e) {
			this.clickOnWebElement(lblLockIcon);
		}

		log.info("Ending of clickOnUnLockIcon method");
	}

	public void clickOnUnlockButton() {
		log.info("Starting of clickOnUnlockButton method");

		hardWait(2);
		this.btnUnlock.click();

		log.info("Ending of clickOnUnlockButton method");
	}

	public void clickOnLockButton() {
		log.info("Starting of clickOnLockButton method");

		hardWait(2);
		this.btnLock.click();

		log.info("Ending of clickOnLockButton method");
	}

	public int getAddedContentCount() {
		log.info("Starting of getAddedContentCount method");
		log.info("Ending of getAddedContentCount method");

		return lstAddedContent.size();

	}

	public String getBuyNowLabel() {
		log.info("Starting of getAttemptTest method");
		log.info("Ending of getAttemptTest method");

		return lblBuyNow.getText();
	}

	public void clickOnReorderMethod() {
		log.info("starting of clickOnTestReorderMethod method");

		this.hardWait(2);
		List<WebElement> imagesList = this.draggableImages;
		for (WebElement item : imagesList) {
			String name = item.getText();
			System.out.println(name);
			System.out.println("------------------------------------------------------------------>");
		}
		this.dragAndSort(imagesList, 0, 2);
		log.info("Ending of clickOnTestReorderMethod method");
	}

	public void reorderImages(String secondIndex, String firstIndex) {
		log.info("Starting of draggableElements method");

		this.explicitWait(draggableImages);
		this.dragAndSort(draggableImages, Integer.parseInt(secondIndex), Integer.parseInt(firstIndex));

		log.info("Ending of draggableElements method");
	}

	public String getSameNameMessageText() {
		explicitWait(titleSameNameMsg);
		return titleSameNameMsg.getText();
	}

	public String getContentEditMessageText() {
		explicitWait(msgContentEdit);
		return msgContentEdit.getText();
	}

	public void clickOnCourseContentList(int i) {
		log.info("Starting of clickOnCourseContentList method");

		lstAddedContent.get(i).click();

		log.info("Ending of clickOnCourseContentList method");

	}

	public boolean isDisplayedMessage() {
		return txtToastMsg.isDisplayed();
	}
	
	public boolean isDisplayedAddOrEditContentWindow() {
		log.info("Starting of isDisplayedEditImportContentWindow method");
		try{
			if (addOrEditContentWindow.isDisplayed())
				return true;
		} catch(Exception e) {
			return false;
		}
		log.info("Starting of isDisplayedEditImportContentWindow method");
		return false;
	}
}
