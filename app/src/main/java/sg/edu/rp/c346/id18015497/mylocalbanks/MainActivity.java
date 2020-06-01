package sg.edu.rp.c346.id18015497.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDbs, tvOcbc, tvUob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDbs = findViewById(R.id.dbsTextView);
        tvOcbc = findViewById(R.id.ocbcTextView);
        tvUob = findViewById(R.id.uobTextView);

        registerForContextMenu(tvDbs);
        registerForContextMenu(tvOcbc);
        registerForContextMenu(tvUob);

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if(v.getId()==R.id.dbsTextView){
            menu.add(0,0,0,"Website");
            menu.add(0,1,1,"Contact the bank");
        }

        if(v.getId()==R.id.ocbcTextView){
            menu.add(0,2,0,"Website");
            menu.add(0,3,1,"Contact the bank");
        }

        if(v.getId()==R.id.uobTextView){
            menu.add(0,4,0,"Website");
            menu.add(0,5,1,"Contact the bank");
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId() == 0) {
            Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
            startActivity(intent);
            return true;
        }

        else if(item.getItemId() == 1) {
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18001111111"));
            startActivity(intentCall);

            return true;
        }

        else if(item.getItemId() == 2) {
            Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
            startActivity(intent);
            return true;
        }

        else if(item.getItemId()== 3) {
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18003633333"));
            startActivity(intentCall);

            return true;
        }

        else if(item.getItemId() == 4) {
            Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
            startActivity(intent);

            return true;
        }

        else if(item.getItemId() == 5) {
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18002222121"));
            startActivity(intentCall);

            return true;
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_language, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDbs.setText("DBS");
            tvOcbc.setText("OCBC");
            tvUob.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDbs.setText("星展银行");
            tvOcbc.setText("华侨银行");
            tvUob.setText("大华银行");
            return true;
        } else {
            tvDbs.setText("error translating");
            tvOcbc.setText("error translating");
            tvUob.setText("error translating");
        }

        return super.onOptionsItemSelected(item);
    }

}
