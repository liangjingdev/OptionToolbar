package activitytest.example.com.toolbarfz;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.liangjing.toolbarlib1.ToolBarActivity;


public class MainActivity extends ToolBarActivity {

    private TextView toolBarTitle;//设置toolBar的title


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    @Override
    public void onCreateCustomToolBar(Toolbar toolbar) {
        super.onCreateCustomToolBar(toolbar);

        //初始化toolBar的title布局，并将其依附到toolBar上。
        View view = getLayoutInflater().inflate(R.layout.toolbar_option, toolbar);

        //获取到设置titleText的TextView控件，然后设置title文字
        toolBarTitle = (TextView) view.findViewById(R.id.toolBarTitle);
        toolBarTitle.setText("微信");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.menu_main, menu);//解析menu布局文件到menu
        MenuItem itemCompat = menu.findItem(R.id.action_search);
        //获取到SearchView对象，即可进行相关操作。
        SearchView mSearchView = (SearchView) MenuItemCompat.getActionView(itemCompat);
        mSearchView.setIconified(false);
        mSearchView.setIconifiedByDefault(false);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
          if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
