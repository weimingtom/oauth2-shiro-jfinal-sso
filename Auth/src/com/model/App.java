package com.model;

import com.auth.base.MyConstant;
import com.auth.util.Empty;
import com.auth.util.TimeUtil;
import com.auth.util.MyUUID;
import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.model.base.BaseApp;

import java.util.List;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class App extends BaseApp<App> {
	public static final App dao = new App();

	public boolean isHasAPP(String client_id){
		String sql = "SELECT * FROM "+ MyConstant.TABLE_PREFIX+"app WHERE app_id = ? ";
		App app = dao.findFirst(sql,client_id);
		return app!=null;
	}

	/**
	 * 根据client_id和client_secret判断是否注册软件
	 * @param client_id 软件id
	 * @param client_secret 软件密码（自动生成，可修改）
	 * @return 有app返回true,否则返回false
	 */
	public boolean isRegister(String client_id, String client_secret){
		String sql = "SELECT * FROM "+ MyConstant.TABLE_PREFIX+"app WHERE app_id = ? AND app_key = ?";
		App app = dao.findFirst(sql,client_id,client_secret);
		return app!=null;
	}

    public Page<App> list(int pageNumber, int pageSize , String keyword){
		String sql = "SELECT * ";
		String where = "  FROM "+MyConstant.TABLE_PREFIX+"app "+keyword;
		return dao.paginate(pageNumber, pageSize, sql, where);
	}


	@Before(Tx.class)
	public boolean save(App app){
		boolean is_success ;
		if(!Empty.isEmpty(app.getAppId())){
			//resid你为空，更新
			is_success = app.set("updated_at", TimeUtil.getTime()).update();
		}else{
			//保存
			is_success = app.set("app_id", MyUUID.getUUID()).set("app_key", MyUUID.getUUID()).set("created_at", TimeUtil.getTime()).save();
		}
		return is_success;
	}


	@Before(Tx.class)
	public boolean delete(List<App> list){
		boolean is_success ;
		for(int i=0;i<list.size();i++){
			App app = list.get(i);
			is_success = app.deleteById(app.getAppId());
			if(is_success){
				String sql = "DELETE FROM "+MyConstant.TABLE_PREFIX+"user_app WHERE app_id = ?";
				Db.update(sql, app.getAppId());
			}else {
				return false;
			}
		}
		return false;
	}



}
