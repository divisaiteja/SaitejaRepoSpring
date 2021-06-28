package com.hrms.dtos;

public class HrShiftsMaster {

	private int shiftid;
	private String name;
	private String starttime;
	private String endtime;
	private int isactive;
	private int gracetime;
	private String lunchouttime;
	private String lunchintime;
	private int duration;
	private int daycrossed;
	private String statusCodeForActive;
	public int getShiftid() {
		return shiftid;
	}

	public void setShiftid(int shiftid) {
		this.shiftid = shiftid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public int getIsactive() {
		return isactive;
	}

	public void setIsactive(int isactive) {
		this.isactive = isactive;
	}

	public int getGracetime() {
		return gracetime;
	}

	public void setGracetime(int gracetime) {
		this.gracetime = gracetime;
	}

	public String getLunchouttime() {
		return lunchouttime;
	}

	public void setLunchouttime(String lunchouttime) {
		this.lunchouttime = lunchouttime;
	}

	public String getLunchintime() {
		return lunchintime;
	}

	public void setLunchintime(String lunchintime) {
		this.lunchintime = lunchintime;
	}

	public int getDaycrossed() {
		return daycrossed;
	}

	public void setDaycrossed(int daycrossed) {
		this.daycrossed = daycrossed;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getStatusCodeForActive() {
		return statusCodeForActive;
	}

	public void setStatusCodeForActive(String statusCodeForActive) {
		this.statusCodeForActive = statusCodeForActive;
	}

}
