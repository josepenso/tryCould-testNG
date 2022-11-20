package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Config;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;


public class FilesPage {

    public FilesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }



    public String newFolderName = "TestFolder" + BrowserUtils.randomNumberGenerator(0, 1000);

    private final String uploadFilePath = Config.getProperty("uploadTestFilePath");
    public final String uploadFileName = Config.getProperty("uploadTestFileName");

    @FindBy(css = ".show .tooltip-inner")
    private WebElement folderAlreadyExistMsg;
    @FindBy(css = "#uploadprogressbar")
    private WebElement uploadLoadingBar;

    @FindBy(css = "#file_upload_start")
    private WebElement hiddenUploadField;

    @FindBy(xpath = "(//tbody[@id='fileList'])[1]")
    public WebElement tBodyElement;

    @FindBy(xpath = "//nav//a[contains(text(),'Comments')]")
    public WebElement commentElement;

    @FindBy(xpath = "(//form//input[@type='submit'])[2]")
    public WebElement submitBtnDetailsOption;

    @FindBy(xpath = "//form//div[@class='message']")
    public WebElement inputMsg;

    @FindAll(@FindBy(xpath = "(//td//span[@class='innernametext'])"))
    public List<WebElement> filesList;

    @FindAll(@FindBy(xpath = "//tbody//td//div[contains(@style,'folder')]"))
    public List<WebElement> folderList;

    @FindAll(@FindBy(xpath = "//td[@class='selection']//label"))
    public List<WebElement> AllCheckBoxes;

    @FindBy(xpath = "(//th[@id='headerSelection']//label//span[contains(text(),'Select all')]/..)[1]")
    public WebElement allBoxesBtn;

    @FindBy(xpath = "//div//button[contains(text(),'Settings')]")
    public WebElement settingBtn;

    @FindBy(xpath = "//li//a[contains(text(),'Deleted files')]/..")
    public WebElement deletedFiles;

    @FindAll(@FindBy(xpath = "//div[@id='app-settings-content']//label[contains(.,'Show')]"))
    public List<WebElement> settingOptions;

    @FindBy(xpath = "//a/p")
    public WebElement storageAmount;

    @FindBy(xpath = "//span[@class='icon icon-add']/..")
    public WebElement addButton;

    @FindBy(xpath = "//input[@id='file_upload_start']")
    public WebElement uploadStart;
    @FindBy (xpath = "//div[@class='toastify on dialogs error toastify-right toastify-top']/span")
    public WebElement notEnoughSpaceBtn;

    @FindBy(xpath = "(//tbody//span[@class='icon icon-more'])")
    public List<WebElement> listActions;
    @FindBy(xpath = "//span[.='Delete file']/..")
    public WebElement deleteDropdown;

    @FindBy(xpath = "(//a/span[@class='icon icon-delete'])[2]")
    public WebElement DeleteOption;

    @FindBy(css = "li[data-id=\"favorites\"]")
    public WebElement favoritesModule;

    @FindAll(@FindBy(css = ".innernametext"))
    public List<WebElement> fileNames;

    @FindAll(@FindBy(css = ".permanent .icon-more"))
    public List<WebElement> actionDots;

    @FindBy(css = ".action-favorite-container")
    public WebElement firstActionsCommand;

    @FindAll(@FindBy(css = "div[class*=\"fileActionsMenu\"]>ul>li span:last-of-type"))
    public List<WebElement> actionsCommandNames;

    @FindAll(@FindBy(css = "div[class*=\"fileActionsMenu\"]>ul>li"))
    public List<WebElement> actionsCommandButtons;

    @FindBy(css = ".action-favorite > span:last-of-type")
    public WebElement firstActionsCommandText;

    @FindBy(css = ".creatable > a")
    public WebElement uploadFileButton;

    @FindAll(@FindBy(css = ".menu-left .menuitem"))
    public List<WebElement> uploadButtonCommands;

    @FindAll(@FindBy(css = ".displayname"))
    public List<WebElement> uploadButtonCommandNames;
    @FindBy(css = "#view13-input-folder")
    public WebElement newFolderNameInput;




    public void uploadBtnClick() {
        BrowserUtils.waitUntilClickable(uploadFileButton,20);
        uploadFileButton.click();
    }





    public void select_option(String option){
        Actions action= new Actions(Driver.getDriver());
        action.moveToElement(findOptionElements(option)).pause(3).click().perform();

    }

    public WebElement getfileUploadedAction(String name) {
        return Driver.getDriver().findElement(By.xpath("//span[.='" + name + "' " +
                "and @class='innernametext']/../..//a[@class='action action-menu permanent']"));
    }






    public WebElement findOptionElements(String option){
        String xPath="//tbody[@id='fileList']//a//span[contains(text(),'"+option+"')]/..";
        return Driver.getDriver().findElement(By.xpath(xPath));
    }


    public WebElement findDetailsOptions(String option) {
        String xPath = "//nav//a[contains(text(),'" + option + "')]";
        return Driver.getDriver().findElement(By.xpath(xPath));
    }

    public WebElement confirmChat(String text ){
        String xPath="//ul[@class='comments']//div[@class='message'][contains(text(),'"+text+"')]";
        return Driver.getDriver().findElement(By.xpath(xPath));
    }

    public WebElement leftSubmodule(String subModule){
        String xPath="//div[@id='app-navigation']//li//a[contains(text(),'"+subModule+"')]";
        return Driver.getDriver().findElement(By.xpath(xPath));
    }



    public WebElement confirmFileAdded(String fileName){
        String xPath="//tbody[@id='fileList']//td[@class='filename']//span[contains(text(),'Eugene')]";
        return Driver.getDriver().findElement(By.xpath(xPath));

    }

    @FindBy(css = "#emptycontent>div[class=\"icon-starred\"]")
    public WebElement noFavoritesYetStar;



    List<String> clickedFiles = new ArrayList<>();

    public void selectAllFiles(String option) {
        if (fileNames.size() == actionDots.size()) {
            if (option.equals("Remove from favorites")) {
                BrowserUtils.waitFor(2);
                removeFromFavorite();
            } else if (option.equals("Add to favorites")) {
                addToFavorites();
            }
        }
    }

    public void addToFavorites() {
        for (int i = 0; i < fileNames.size(); i++) {
            clickedFiles.add(fileNames.get(i).getText());
            BrowserUtils.waitUntilClickable(actionDots.get(i),20);
            actionDots.get(i).click();
            BrowserUtils.waitUntilClickable(firstActionsCommand,20);
            actionsMenuClick("Add to favorites");
        }
    }

    public void removeFromFavorite() {
        int i = 0;
        while (true) {
            BrowserUtils.waitUntilClickable(actionDots.get(0),20);
            actionDots.get(0).click();
            BrowserUtils.waitUntilClickable(firstActionsCommand,20);
            if (!firstActionsCommandText.getText().equals("Remove from favorites")) {
                break;
            } else {
                actionsMenuClick("Remove from favorites");
                BrowserUtils.sleep(1);
            }
        }
    }

    public void clickFavorites() {
        favoritesModule.click();
       BrowserUtils.sleep(3);
    }

    public void actionsMenuClick(String command) {
        for (int i = 0; i < actionsCommandNames.size(); i++) {
            if (!actionsCommandNames.get(i).getText().isBlank()) {
                if (actionsCommandNames.get(i).getText().strip().equals(command)) {
                    actionsCommandButtons.get(i).click();
                    break;
                } else if (actionsCommandNames.get(i).getText().contains("Remove from favorites")) {

                    actionsCommandButtons.get(i).click();
                    break;
                }
            }
        }
    }

    public void verifyFavFiles() {
        Files_Favorites files_favorites = new Files_Favorites();
        System.out.println("Clicked Files = " + clickedFiles);
        System.out.println("Files in Favorites = " + files_favorites.favFileList());
        assertTrue(files_favorites.favFileList().containsAll(clickedFiles));
    }

    public void uploadCommand(String command) {
        for (int i = 0; i < uploadButtonCommands.size(); i++) {
            if (uploadButtonCommandNames.get(i).getText().equalsIgnoreCase(command) && command.equalsIgnoreCase("upload file")) {
                directFileUpload();
                break;
            } else if (uploadButtonCommandNames.get(i).getText().equalsIgnoreCase(command) && command.equalsIgnoreCase("new folder")) {
                uploadButtonCommands.get(i).click();
                newFolderNameInput.clear();
                newFolderNameInput.sendKeys(newFolderName);
                BrowserUtils.waitFor(2);

            }
        }
    }

    public void verifyFileUpload() {
        List<String> allVisibleFileNames = new ArrayList<>();
        for (WebElement fileName : fileNames) {
            allVisibleFileNames.add(fileName.getText());
        }
        System.out.println("All Visible Files = " + allVisibleFileNames);
        System.out.println("Uploaded File name = " + uploadFileName);
        assertTrue(allVisibleFileNames.contains(uploadFileName));
    }

    public void directFileUpload() {
        System.out.println("Upload File Name = " + uploadFileName);
        for (int i = 0; i < fileNames.size(); i++) {
            if (fileNames.get(i).getText().strip().equals(uploadFileName)) {
                actionDots.get(i).click();
                actionsMenuClick("Delete");
                Driver.getDriver().navigate().refresh();
                BrowserUtils.waitUntilClickable(uploadFileButton,20);
                break;
            }
        }
        uploadBtnClick();
        hiddenUploadField.sendKeys(uploadFilePath);
        BrowserUtils.waitUntilNotVisible(uploadLoadingBar,20);
    }










}
