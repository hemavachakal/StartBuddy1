package com.example.startbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;

public class Knowing extends AppCompatActivity {

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowing);

        mainGrid =findViewById(R.id.mainGrid);
        ClickOneGrid(mainGrid);

    }

  private void ClickOneGrid(GridLayout mainGrid) {
      for (int i = 0; i < mainGrid.getChildCount(); i++) {
          CardView cardView = (CardView) mainGrid.getChildAt(i);
          final int finalI = i;
          cardView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {

                  if(finalI == 0)

                  {
                      Intent intent = new Intent(Knowing.this, Diag.class);

                      startActivity(intent);
                  }
                  if(finalI == 1)
                  {
                      Intent intent2 = new Intent(Knowing.this, Stomach.class);
                      startActivity(intent2);
                  }
                  if(finalI == 2)
                  {
                      Intent intent2 = new Intent(Knowing.this, Balloon.class);
                      startActivity(intent2);
                  }
                  if(finalI == 3)
                  {
                      Intent intent2 = new Intent(Knowing.this, Ribcage.class);
                      startActivity(intent2);
                  }
                  if(finalI == 4)
                  {
                      Intent intent2 = new Intent(Knowing.this, Body.class);
                      startActivity(intent2);
                  }
                  if(finalI == 5)
                  {
                      Intent intent2 = new Intent(Knowing.this, Retreat.class);
                      startActivity(intent2);
                  }

              }
          });
      }
  }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.help,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();

        if(id == R.id.menuitem1)
        {
            Intent back = new Intent(this,Aboutus.class);
            startActivity(back);
        }

        return true;


    }

}
