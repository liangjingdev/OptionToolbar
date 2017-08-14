package activitytest.example.com.mylibrary;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import activitytest.example.com.mylibrary.helper.ToolBarHelper;


/**
 * 1、 toolbar.xml中配置 toolbar 的基本属性：
 * toolbar 的宽高，toolbar 的背景颜色等其他样式
 * 2、ToolBarActivity.java是所以需要使用 toolbar Activity 的父类，
 * 这里我把他定义为抽象类，因为单独的这个类不能完成任何功能
 * 3、ToolBarActivity.java的内容：主要代码是在setContentView（int id） 实现
 * 4、该Activity首先从工具类ToolBarHelper中取得父视图以及ToolBar,然后设置好父视图，接着
 *    可以利用ToolBar做一些相应的处理操作
 */

public abstract class ToolBarActivity extends AppCompatActivity {

    private ToolBarHelper mToolBarHelper ;

    public Toolbar toolbar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //这里的layoutResID即子类传递过来的R.layout.activity_main
    @Override
    public void setContentView(int layoutResID) {

        mToolBarHelper = new ToolBarHelper(this,layoutResID) ;//这个this指的是当前的context。
        toolbar = mToolBarHelper.getToolBar() ;
        setContentView(mToolBarHelper.getContentView());//为活动设置视图
        /*把 toolbar 设置到Activity 中*/
        setSupportActionBar(toolbar);
        /*自定义的一些操作*/
        onCreateCustomToolBar(toolbar) ;
    }

    //并且该方法可公布出去给外界调用，此时在外界也可自定义一些相关操作
    public void onCreateCustomToolBar(Toolbar toolbar){
        toolbar.setContentInsetsRelative(0,0);
        toolbar.showOverflowMenu() ;
        getLayoutInflater().inflate(R.layout.toolbar_button, toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
            return true ;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);//解析menu布局文件到menu
        MenuItem itemCompat = menu.findItem(R.id.action_search) ;
        SearchView mSearchView = (SearchView) MenuItemCompat.getActionView(itemCompat);
        mSearchView.setIconified(false);
        mSearchView.setIconifiedByDefault(false);
        return true;
    }
}
