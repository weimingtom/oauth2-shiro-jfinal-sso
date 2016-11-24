package com.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseApp<M extends BaseApp<M>> extends Model<M> implements IBean {

	public void setAppId(java.lang.String appId) {
		set("app_id", appId);
	}

	public java.lang.String getAppId() {
		return get("app_id");
	}

	public void setAppName(java.lang.String appName) {
		set("app_name", appName);
	}

	public java.lang.String getAppName() {
		return get("app_name");
	}

	public void setAppKey(java.lang.String appKey) {
		set("app_key", appKey);
	}

	public java.lang.String getAppKey() {
		return get("app_key");
	}

	public void setAppRedirectUri(java.lang.String appRedirectUri) {
		set("app_redirect_uri", appRedirectUri);
	}

	public java.lang.String getAppRedirectUri() {
		return get("app_redirect_uri");
	}

	public void setCreatedAt(java.lang.String createdAt) {
		set("created_at", createdAt);
	}

	public java.lang.String getCreatedAt() {
		return get("created_at");
	}

	public void setUpdatedAt(java.lang.String updatedAt) {
		set("updated_at", updatedAt);
	}

	public java.lang.String getUpdatedAt() {
		return get("updated_at");
	}

}