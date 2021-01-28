package com.abubaker.ili_task;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.EntryXComparator;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

   LineChart lineChart;
    Button buttons[] = new Button[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons[0] = (Button)findViewById(R.id.btn0);
        buttons[1] = (Button)findViewById(R.id.btn1);
        buttons[2] = (Button)findViewById(R.id.btn2);
        buttons[3] = (Button)findViewById(R.id.btn3);

        for (int i=0;i<buttons.length;i++)
        {
            final int finalI = i;
            buttons[i].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if(v.getId() == buttons[0].getId()) {
                        buttons[0].setBackground(getResources().getDrawable(R.drawable.btn_round));
                        buttons[1].setBackground(getResources().getDrawable(R.drawable.btn_transparent));
                        buttons[2].setBackground(getResources().getDrawable(R.drawable.btn_transparent));
                        buttons[3].setBackground(getResources().getDrawable(R.drawable.btn_transparent));
                    }
                    if(v.getId() == buttons[1].getId()) {
                        buttons[1].setBackground(getResources().getDrawable(R.drawable.btn_round));
                        buttons[0].setBackground(getResources().getDrawable(R.drawable.btn_transparent));
                        buttons[2].setBackground(getResources().getDrawable(R.drawable.btn_transparent));
                        buttons[3].setBackground(getResources().getDrawable(R.drawable.btn_transparent));
                    }
                    if(v.getId() == buttons[2].getId()) {
                        buttons[2].setBackground(getResources().getDrawable(R.drawable.btn_round));
                        buttons[1].setBackground(getResources().getDrawable(R.drawable.btn_transparent));
                        buttons[0].setBackground(getResources().getDrawable(R.drawable.btn_transparent));
                        buttons[3].setBackground(getResources().getDrawable(R.drawable.btn_transparent));
                    }
                    if(v.getId() == buttons[3].getId()) {
                        buttons[3].setBackground(getResources().getDrawable(R.drawable.btn_round));
                        buttons[1].setBackground(getResources().getDrawable(R.drawable.btn_transparent));
                        buttons[2].setBackground(getResources().getDrawable(R.drawable.btn_transparent));
                        buttons[0].setBackground(getResources().getDrawable(R.drawable.btn_transparent));
                    }



                }
            });

        }




        lineChart=findViewById(R.id.linechart);
        LineDataSet lineDataSet=new LineDataSet(dataValuesDaily(),"");
        lineDataSet.setColor(ColorTemplate.rgb("#70AB1E"));
        lineDataSet.setLineWidth(3);

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setTextColor(Color.WHITE);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return dataX().get((int)value);
            }
        });
        YAxis yAxis = lineChart.getAxisRight();
        yAxis.setEnabled(false);
        yAxis=lineChart.getAxisLeft();
        yAxis.setDrawGridLines(false);
        yAxis.setTextColor(Color.WHITE);





        ArrayList<ILineDataSet> dataSets=new ArrayList<>();
        dataSets.add(lineDataSet);
        lineChart.setDrawGridBackground(false);
        lineChart.setDrawBorders(false);
        lineChart.setBorderWidth(2);
        lineChart.getAxisLeft().setEnabled(true);
        lineChart.getAxisRight().setEnabled(false);
        lineChart.setBorderColor(Color.WHITE);

        LineData data=new LineData(dataSets);
        lineChart.setData(data);
        lineChart.invalidate();

    }

    private ArrayList<Entry> dataValuesDaily(){
        ArrayList<Entry> dataVals = new ArrayList<>();
        dataVals.add(new Entry(0,24));
        dataVals.add(new Entry(1,15));
        dataVals.add(new Entry(2,18));
        dataVals.add(new Entry(3,13));
        dataVals.add(new Entry(4,17));
        dataVals.add(new Entry(5,14));
        return dataVals;
    }
    private ArrayList<String> dataX()
    {
        final ArrayList<String> xLabel = new ArrayList<>();
        xLabel.add("4AM");
        xLabel.add("8AM");
        xLabel.add("12PM");
        xLabel.add("16PM");
        xLabel.add("20PM");
        xLabel.add("0AM");

        return xLabel;
    }
    private ArrayList<String> dataY()
    {
        final ArrayList<String> yLabel = new ArrayList<>();
        yLabel.add("0");
        yLabel.add("10");
        yLabel.add("20");
        yLabel.add("30");

        return yLabel;
    }
}
