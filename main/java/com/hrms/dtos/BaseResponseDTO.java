package com.hrms.dtos;

import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class BaseResponseDTO {
	/**
	 * the customer locale error message
	 */
	private String errorCode;

	private String errorMessage;

	/**
	 * the customer locale error message
	 */
//	private List<ErrorMessageDTO> errorMessages;

	/** the title for the error dialog to be displayed */
	private String errorDialogTitle;

	/** Was the update successful, or should we show error messages? */

	private boolean success;
	/** Data object returned */

	private Object dataBean;

	/**
	 * the success response message in case successfully completion of operation
	 */
	private String successMessage;

	public BaseResponseDTO(Exception e) {
		success = false;
		errorMessage = e.getMessage();
	}

	public BaseResponseDTO(boolean success, Object dataBean) {
		this.success = success;
		this.dataBean = dataBean;
	}

	public BaseResponseDTO() {
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getDataBean() {
		return dataBean;
	}

	public void setDataBean(Object dataBean) {
		this.dataBean = dataBean;
	}

	/**
	 * @return the errorDialogTitle
	 */
	public String getErrorDialogTitle() {
		return errorDialogTitle;
	}

	/**
	 * @param errorDialogTitle
	 *            the errorDialogTitle to set
	 */
	public void setErrorDialogTitle(String errorDialogTitle) {
		this.errorDialogTitle = errorDialogTitle;
	}

	/**
	 * @return the successMessage
	 */
	public String getSuccessMessage() {
		return successMessage;
	}

	/**
	 * @param successMessage
	 *            the successMessage to set
	 */
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	
	/**
	 * @return the errorMessages
	 */
	/*
	public List<ErrorMessageDTO> getErrorMessages() {
		return errorMessages;
	}

*/
	/**
	 * @param errorMessages
	 *            the errorMessages to set
	 */
	/*
	public void setErrorMessages(List<ErrorMessageDTO> errorMessages) {
		this.errorMessages = errorMessages;
	}
	*/

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return "BaseResponseDTO [errorMessage=" + errorMessage + ", errorDialogTitle=" + errorDialogTitle + ", success=" + success
				+ ", dataBean=" + dataBean + ", successMessage=" + successMessage + "]";
	}

}
