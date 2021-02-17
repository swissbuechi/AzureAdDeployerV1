package ch.netider.AzureAdDeployer.service.microsoftonline;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MicrosoftOnlineUser {

    @SerializedName("AlternateEmailAddresses")
    @Expose
    private List<String> alternateEmailAddresses = null;
    @SerializedName("AlternateMobilePhones")
    @Expose
    private List<Object> alternateMobilePhones = null;
    @SerializedName("AlternativeSecurityIds")
    @Expose
    private List<Object> alternativeSecurityIds = null;
    @SerializedName("BlockCredential")
    @Expose
    private Boolean blockCredential;
    @SerializedName("City")
    @Expose
    private Object city;
    @SerializedName("CloudExchangeRecipientDisplayType")
    @Expose
    private Object cloudExchangeRecipientDisplayType;
    @SerializedName("Country")
    @Expose
    private Object country;
    @SerializedName("Department")
    @Expose
    private Object department;
    @SerializedName("DirSyncProvisioningErrors")
    @Expose
    private List<Object> dirSyncProvisioningErrors = null;
    @SerializedName("DisplayName")
    @Expose
    private String displayName;
    @SerializedName("Errors")
    @Expose
    private Object errors;
    @SerializedName("Fax")
    @Expose
    private Object fax;
    @SerializedName("FirstName")
    @Expose
    private Object firstName;
    @SerializedName("ImmutableId")
    @Expose
    private Object immutableId;
    @SerializedName("IndirectLicenseErrors")
    @Expose
    private List<Object> indirectLicenseErrors = null;
    @SerializedName("IsBlackberryUser")
    @Expose
    private Boolean isBlackberryUser;
    @SerializedName("IsLicensed")
    @Expose
    private Boolean isLicensed;
    @SerializedName("LastDirSyncTime")
    @Expose
    private Object lastDirSyncTime;
    @SerializedName("LastName")
    @Expose
    private Object lastName;
    @SerializedName("LastPasswordChangeTimestamp")
    @Expose
    private String lastPasswordChangeTimestamp;
    @SerializedName("LicenseAssignmentDetails")
    @Expose
    private List<Object> licenseAssignmentDetails = null;
    @SerializedName("LicenseReconciliationNeeded")
    @Expose
    private Boolean licenseReconciliationNeeded;
    @SerializedName("Licenses")
    @Expose
    private List<Object> licenses = null;
    @SerializedName("LiveId")
    @Expose
    private String liveId;
    @SerializedName("MSExchRecipientTypeDetails")
    @Expose
    private Object mSExchRecipientTypeDetails;
    @SerializedName("MSRtcSipDeploymentLocator")
    @Expose
    private Object mSRtcSipDeploymentLocator;
    @SerializedName("MSRtcSipPrimaryUserAddress")
    @Expose
    private Object mSRtcSipPrimaryUserAddress;
    @SerializedName("MobilePhone")
    @Expose
    private Object mobilePhone;
    @SerializedName("ObjectId")
    @Expose
    private String objectId;
    @SerializedName("Office")
    @Expose
    private Object office;
    @SerializedName("OverallProvisioningStatus")
    @Expose
    private Integer overallProvisioningStatus;
    @SerializedName("PasswordNeverExpires")
    @Expose
    private Boolean passwordNeverExpires;
    @SerializedName("PasswordResetNotRequiredDuringActivate")
    @Expose
    private Object passwordResetNotRequiredDuringActivate;
    @SerializedName("PhoneNumber")
    @Expose
    private Object phoneNumber;
    @SerializedName("PortalSettings")
    @Expose
    private Object portalSettings;
    @SerializedName("PostalCode")
    @Expose
    private Object postalCode;
    @SerializedName("PreferredDataLocation")
    @Expose
    private Object preferredDataLocation;
    @SerializedName("PreferredLanguage")
    @Expose
    private Object preferredLanguage;
    @SerializedName("ProxyAddresses")
    @Expose
    private List<String> proxyAddresses = null;
    @SerializedName("ReleaseTrack")
    @Expose
    private Object releaseTrack;
    @SerializedName("ServiceInformation")
    @Expose
    private List<Object> serviceInformation = null;
    @SerializedName("SignInName")
    @Expose
    private String signInName;
    @SerializedName("SoftDeletionTimestamp")
    @Expose
    private Object softDeletionTimestamp;
    @SerializedName("State")
    @Expose
    private Object state;
    @SerializedName("StreetAddress")
    @Expose
    private Object streetAddress;
    @SerializedName("StrongAuthenticationMethods")
    @Expose
    private List<String> strongAuthenticationMethods = null;
    @SerializedName("StrongAuthenticationPhoneAppDetails")
    @Expose
    private List<String> strongAuthenticationPhoneAppDetails = null;
    @SerializedName("StrongAuthenticationProofupTime")
    @Expose
    private Object strongAuthenticationProofupTime;
    @SerializedName("StrongAuthenticationRequirements")
    @Expose
    private List<Object> strongAuthenticationRequirements = null;
    @SerializedName("StrongAuthenticationUserDetails")
    @Expose
    private Object strongAuthenticationUserDetails;
    @SerializedName("StrongPasswordRequired")
    @Expose
    private Boolean strongPasswordRequired;
    @SerializedName("StsRefreshTokensValidFrom")
    @Expose
    private String stsRefreshTokensValidFrom;
    @SerializedName("Title")
    @Expose
    private Object title;
    @SerializedName("UsageLocation")
    @Expose
    private Object usageLocation;
    @SerializedName("UserLandingPageIdentifierForO365Shell")
    @Expose
    private Object userLandingPageIdentifierForO365Shell;
    @SerializedName("UserPrincipalName")
    @Expose
    private String userPrincipalName;
    @SerializedName("UserThemeIdentifierForO365Shell")
    @Expose
    private Object userThemeIdentifierForO365Shell;
    @SerializedName("UserType")
    @Expose
    private Integer userType;
    @SerializedName("ValidationStatus")
    @Expose
    private Integer validationStatus;
    @SerializedName("WhenCreated")
    @Expose
    private String whenCreated;

    public List<String> getAlternateEmailAddresses() {
        return alternateEmailAddresses;
    }

    public void setAlternateEmailAddresses(List<String> alternateEmailAddresses) {
        this.alternateEmailAddresses = alternateEmailAddresses;
    }

    public List<Object> getAlternateMobilePhones() {
        return alternateMobilePhones;
    }

    public void setAlternateMobilePhones(List<Object> alternateMobilePhones) {
        this.alternateMobilePhones = alternateMobilePhones;
    }

    public List<Object> getAlternativeSecurityIds() {
        return alternativeSecurityIds;
    }

    public void setAlternativeSecurityIds(List<Object> alternativeSecurityIds) {
        this.alternativeSecurityIds = alternativeSecurityIds;
    }

    public Boolean getBlockCredential() {
        return blockCredential;
    }

    public void setBlockCredential(Boolean blockCredential) {
        this.blockCredential = blockCredential;
    }

    public Object getCity() {
        return city;
    }

    public void setCity(Object city) {
        this.city = city;
    }

    public Object getCloudExchangeRecipientDisplayType() {
        return cloudExchangeRecipientDisplayType;
    }

    public void setCloudExchangeRecipientDisplayType(Object cloudExchangeRecipientDisplayType) {
        this.cloudExchangeRecipientDisplayType = cloudExchangeRecipientDisplayType;
    }

    public Object getCountry() {
        return country;
    }

    public void setCountry(Object country) {
        this.country = country;
    }

    public Object getDepartment() {
        return department;
    }

    public void setDepartment(Object department) {
        this.department = department;
    }

    public List<Object> getDirSyncProvisioningErrors() {
        return dirSyncProvisioningErrors;
    }

    public void setDirSyncProvisioningErrors(List<Object> dirSyncProvisioningErrors) {
        this.dirSyncProvisioningErrors = dirSyncProvisioningErrors;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Object getErrors() {
        return errors;
    }

    public void setErrors(Object errors) {
        this.errors = errors;
    }

    public Object getFax() {
        return fax;
    }

    public void setFax(Object fax) {
        this.fax = fax;
    }

    public Object getFirstName() {
        return firstName;
    }

    public void setFirstName(Object firstName) {
        this.firstName = firstName;
    }

    public Object getImmutableId() {
        return immutableId;
    }

    public void setImmutableId(Object immutableId) {
        this.immutableId = immutableId;
    }

    public List<Object> getIndirectLicenseErrors() {
        return indirectLicenseErrors;
    }

    public void setIndirectLicenseErrors(List<Object> indirectLicenseErrors) {
        this.indirectLicenseErrors = indirectLicenseErrors;
    }

    public Boolean getIsBlackberryUser() {
        return isBlackberryUser;
    }

    public void setIsBlackberryUser(Boolean isBlackberryUser) {
        this.isBlackberryUser = isBlackberryUser;
    }

    public Boolean getIsLicensed() {
        return isLicensed;
    }

    public void setIsLicensed(Boolean isLicensed) {
        this.isLicensed = isLicensed;
    }

    public Object getLastDirSyncTime() {
        return lastDirSyncTime;
    }

    public void setLastDirSyncTime(Object lastDirSyncTime) {
        this.lastDirSyncTime = lastDirSyncTime;
    }

    public Object getLastName() {
        return lastName;
    }

    public void setLastName(Object lastName) {
        this.lastName = lastName;
    }

    public String getLastPasswordChangeTimestamp() {
        return lastPasswordChangeTimestamp;
    }

    public void setLastPasswordChangeTimestamp(String lastPasswordChangeTimestamp) {
        this.lastPasswordChangeTimestamp = lastPasswordChangeTimestamp;
    }

    public List<Object> getLicenseAssignmentDetails() {
        return licenseAssignmentDetails;
    }

    public void setLicenseAssignmentDetails(List<Object> licenseAssignmentDetails) {
        this.licenseAssignmentDetails = licenseAssignmentDetails;
    }

    public Boolean getLicenseReconciliationNeeded() {
        return licenseReconciliationNeeded;
    }

    public void setLicenseReconciliationNeeded(Boolean licenseReconciliationNeeded) {
        this.licenseReconciliationNeeded = licenseReconciliationNeeded;
    }

    public List<Object> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<Object> licenses) {
        this.licenses = licenses;
    }

    public String getLiveId() {
        return liveId;
    }

    public void setLiveId(String liveId) {
        this.liveId = liveId;
    }

    public Object getMSExchRecipientTypeDetails() {
        return mSExchRecipientTypeDetails;
    }

    public void setMSExchRecipientTypeDetails(Object mSExchRecipientTypeDetails) {
        this.mSExchRecipientTypeDetails = mSExchRecipientTypeDetails;
    }

    public Object getMSRtcSipDeploymentLocator() {
        return mSRtcSipDeploymentLocator;
    }

    public void setMSRtcSipDeploymentLocator(Object mSRtcSipDeploymentLocator) {
        this.mSRtcSipDeploymentLocator = mSRtcSipDeploymentLocator;
    }

    public Object getMSRtcSipPrimaryUserAddress() {
        return mSRtcSipPrimaryUserAddress;
    }

    public void setMSRtcSipPrimaryUserAddress(Object mSRtcSipPrimaryUserAddress) {
        this.mSRtcSipPrimaryUserAddress = mSRtcSipPrimaryUserAddress;
    }

    public Object getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(Object mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public Object getOffice() {
        return office;
    }

    public void setOffice(Object office) {
        this.office = office;
    }

    public Integer getOverallProvisioningStatus() {
        return overallProvisioningStatus;
    }

    public void setOverallProvisioningStatus(Integer overallProvisioningStatus) {
        this.overallProvisioningStatus = overallProvisioningStatus;
    }

    public Boolean getPasswordNeverExpires() {
        return passwordNeverExpires;
    }

    public void setPasswordNeverExpires(Boolean passwordNeverExpires) {
        this.passwordNeverExpires = passwordNeverExpires;
    }

    public Object getPasswordResetNotRequiredDuringActivate() {
        return passwordResetNotRequiredDuringActivate;
    }

    public void setPasswordResetNotRequiredDuringActivate(Object passwordResetNotRequiredDuringActivate) {
        this.passwordResetNotRequiredDuringActivate = passwordResetNotRequiredDuringActivate;
    }

    public Object getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Object phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Object getPortalSettings() {
        return portalSettings;
    }

    public void setPortalSettings(Object portalSettings) {
        this.portalSettings = portalSettings;
    }

    public Object getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Object postalCode) {
        this.postalCode = postalCode;
    }

    public Object getPreferredDataLocation() {
        return preferredDataLocation;
    }

    public void setPreferredDataLocation(Object preferredDataLocation) {
        this.preferredDataLocation = preferredDataLocation;
    }

    public Object getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(Object preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public List<String> getProxyAddresses() {
        return proxyAddresses;
    }

    public void setProxyAddresses(List<String> proxyAddresses) {
        this.proxyAddresses = proxyAddresses;
    }

    public Object getReleaseTrack() {
        return releaseTrack;
    }

    public void setReleaseTrack(Object releaseTrack) {
        this.releaseTrack = releaseTrack;
    }

    public List<Object> getServiceInformation() {
        return serviceInformation;
    }

    public void setServiceInformation(List<Object> serviceInformation) {
        this.serviceInformation = serviceInformation;
    }

    public String getSignInName() {
        return signInName;
    }

    public void setSignInName(String signInName) {
        this.signInName = signInName;
    }

    public Object getSoftDeletionTimestamp() {
        return softDeletionTimestamp;
    }

    public void setSoftDeletionTimestamp(Object softDeletionTimestamp) {
        this.softDeletionTimestamp = softDeletionTimestamp;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }

    public Object getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(Object streetAddress) {
        this.streetAddress = streetAddress;
    }

    public List<String> getStrongAuthenticationMethods() {
        return strongAuthenticationMethods;
    }

    public void setStrongAuthenticationMethods(List<String> strongAuthenticationMethods) {
        this.strongAuthenticationMethods = strongAuthenticationMethods;
    }

    public List<String> getStrongAuthenticationPhoneAppDetails() {
        return strongAuthenticationPhoneAppDetails;
    }

    public void setStrongAuthenticationPhoneAppDetails(List<String> strongAuthenticationPhoneAppDetails) {
        this.strongAuthenticationPhoneAppDetails = strongAuthenticationPhoneAppDetails;
    }

    public Object getStrongAuthenticationProofupTime() {
        return strongAuthenticationProofupTime;
    }

    public void setStrongAuthenticationProofupTime(Object strongAuthenticationProofupTime) {
        this.strongAuthenticationProofupTime = strongAuthenticationProofupTime;
    }

    public List<Object> getStrongAuthenticationRequirements() {
        return strongAuthenticationRequirements;
    }

    public void setStrongAuthenticationRequirements(List<Object> strongAuthenticationRequirements) {
        this.strongAuthenticationRequirements = strongAuthenticationRequirements;
    }

    public Object getStrongAuthenticationUserDetails() {
        return strongAuthenticationUserDetails;
    }

    public void setStrongAuthenticationUserDetails(Object strongAuthenticationUserDetails) {
        this.strongAuthenticationUserDetails = strongAuthenticationUserDetails;
    }

    public Boolean getStrongPasswordRequired() {
        return strongPasswordRequired;
    }

    public void setStrongPasswordRequired(Boolean strongPasswordRequired) {
        this.strongPasswordRequired = strongPasswordRequired;
    }

    public String getStsRefreshTokensValidFrom() {
        return stsRefreshTokensValidFrom;
    }

    public void setStsRefreshTokensValidFrom(String stsRefreshTokensValidFrom) {
        this.stsRefreshTokensValidFrom = stsRefreshTokensValidFrom;
    }

    public Object getTitle() {
        return title;
    }

    public void setTitle(Object title) {
        this.title = title;
    }

    public Object getUsageLocation() {
        return usageLocation;
    }

    public void setUsageLocation(Object usageLocation) {
        this.usageLocation = usageLocation;
    }

    public Object getUserLandingPageIdentifierForO365Shell() {
        return userLandingPageIdentifierForO365Shell;
    }

    public void setUserLandingPageIdentifierForO365Shell(Object userLandingPageIdentifierForO365Shell) {
        this.userLandingPageIdentifierForO365Shell = userLandingPageIdentifierForO365Shell;
    }

    public String getUserPrincipalName() {
        return userPrincipalName;
    }

    public void setUserPrincipalName(String userPrincipalName) {
        this.userPrincipalName = userPrincipalName;
    }

    public Object getUserThemeIdentifierForO365Shell() {
        return userThemeIdentifierForO365Shell;
    }

    public void setUserThemeIdentifierForO365Shell(Object userThemeIdentifierForO365Shell) {
        this.userThemeIdentifierForO365Shell = userThemeIdentifierForO365Shell;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getValidationStatus() {
        return validationStatus;
    }

    public void setValidationStatus(Integer validationStatus) {
        this.validationStatus = validationStatus;
    }

    public String getWhenCreated() {
        return whenCreated;
    }

    public void setWhenCreated(String whenCreated) {
        this.whenCreated = whenCreated;
    }

}

