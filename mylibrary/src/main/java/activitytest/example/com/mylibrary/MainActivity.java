package activitytest.example.com.mylibrary;

import android.os.Bundle;


/**
 * 因为这里的MainActivity继承自ToolBarActivity，
 * 所以当执行应用程序的时候，ToolBarActivity（即父类）
 * 会首先被创建（运行），然后再到其子类被创建。
 *
 * 注意：onCreateOptionsMenu(Menu menu)方法和onOptionsItemSelected(MenuItem item)方法中的相应逻辑
 *      也可放在其父类ToolBarActivity中进行处理。那么主活动中的代码就会减少一些
 */
public class MainActivity extends ToolBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//这句话的意思就是：调用父类的方法。
        setContentView(R.layout.activity_main);//因为父类在子类（调用自己的构造函数）被创建的时候同时也会被创建，所以这个R.layout.activity_main（int值）会在此时传递到父类的setContentView()方法中。
    }

/*
    由于以下这些方法中的一些相应的逻辑也可以在父类ToolBarActivity中实现，所以可把这些处理逻辑放到父类中去，减少主活动的代码。
    若有些处理逻辑想要在主活动中实现的话，那么也可继承父类的方法，然后在这些方法中做相应的处理。
    @Override
    public void onCreateCustomToolBar(Toolbar toolbar) {
        super.onCreateCustomToolBar(toolbar);//这是继承自父类的方法，需首先调用父类的onCreateCustomToolBar()方法
        toolbar.showOverflowMenu() ;
        getLayoutInflater().inflate(R.layout.toolbar_button, toolbar) ;
    }
*/
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);//解析menu布局文件到menu
        MenuItem itemCompat = menu.findItem(R.id.action_search) ;
        SearchView mSearchView = (SearchView) MenuItemCompat.getActionView(itemCompat);
        mSearchView.setIconified(false);
        mSearchView.setIconifiedByDefault(false);
        return true;
    }
*/
/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
 */
}

/**
 setIconified

 void setIconified（boolean iconify）

 图标化或扩展SearchView。图标化时，任何查询文本都将被清除。这是一个临时状态，不会覆盖设置的默认图标化状态 setIconifiedByDefault(boolean)。如果默认状态是图标化的，那么这里的false只有在用户关闭该字段之前才有效。并且如果默认状态被展开，那么这里的true只会清除文本字段而不是关闭它。

 参数
 iconify	boolean：一个真正的值会将SearchView折叠到一个图标，而一个false会展开它。
 */



/**
 * setIconifiedByDefault

 void setIconifiedByDefault（boolean iconified）

 设置搜索字段的默认或静止状态。如果为true，则默认显示单个搜索图标，并在按下时展开以显示文本字段和其他按钮。此外，如果默认状态为图标，则当按下关闭按钮时，它将折叠到该状态。对此属性的更改将立即生效。

 默认值为true。

 相关XML属性：

 android.support.v7.appcompat：iconifiedByDefault
 参数
 iconified	boolean：搜索字段是否应该默认图标化
 */

/**
 * 那个父类的实例是在调用子类的构造函数的时候创建的，
 * 被包含在子类对象的内部，它里面的属性和方法必须通过子类对象才能访问到，
 * 除非你是单独创建了一个父类实例（不是在创建子类实例的时候创建的）。
 */


/**
 * showOverflowMenu

 boolean showOverflowMenu ()
 显示相关菜单中的溢出项目。

 退货
 boolean	如果菜单能够显示，则为true，否则为false
 */