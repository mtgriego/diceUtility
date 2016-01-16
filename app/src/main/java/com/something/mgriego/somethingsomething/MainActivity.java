package com.something.mgriego.somethingsomething;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int numD2 = 0;
    int numD4 = 0;
    int numD6 = 0;
    int numD8 = 0;
    int numD10 = 0;
    int numD12 = 0;
    int numD20 = 0;
    int numD50 = 0;
    int numD100 = 0;
    boolean diceSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Integer> numSides = new ArrayList<>();
        ArrayList<Integer> numDice = new ArrayList<>();

        numSides.add(2);
        numSides.add(4);
        numSides.add(6);
        numSides.add(8);
        numSides.add(10);
        numSides.add(12);
        numSides.add(20);
        numSides.add(50);
        numSides.add(100);

        for(int i = 0; i < 100; i++){
            numDice.add(i+1);
        }

        ArrayAdapter<Integer> sidesAdapter = new ArrayAdapter<Integer>(this, R.layout.spinner_item, numSides);
        sidesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<Integer> diceAdapter = new ArrayAdapter<Integer>(this, R.layout.spinner_item, numDice);
        diceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final Spinner sides = (Spinner) findViewById(R.id.numSidesSpiner);
        sides.setAdapter(sidesAdapter);
        final EditText dice = (EditText) findViewById(R.id.numDiceText);

        final ListView list = (ListView) findViewById(R.id.listView);
        final TextView total = (TextView) findViewById(R.id.totalResult);
        final TextView crits = (TextView) findViewById(R.id.critText);
        final TextView fails = (TextView) findViewById(R.id.failText);
        final TextView averageText = (TextView) findViewById(R.id.averageText);

        final boolean visible = false;

        Button rollButton = (Button) findViewById(R.id.rollButton);
        Button addDiceButton = (Button) findViewById(R.id.addDiceButton);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(dice.getText().toString()) > 0 && Integer.parseInt(dice.getText().toString()) < 1000) {


                    ArrayList<String> resultList = new ArrayList<String>();
                    int totalResult = 0;
                    int numCrits = 0;
                    int numFails = 0;
                    int numRolls = 0;
                    double average;
                    final ArrayList<Integer> ones = new ArrayList<Integer>();
                    final ArrayList<Integer> crit = new ArrayList<Integer>();
                    ArrayAdapter<String> resultsAdapter;

                    if (diceSelected) {
                        int resultsD2[] = rollDice(numD2, 2);
                        if (resultsD2.length > 0) {
                            for (int i = 0; i < resultsD2.length; i++) {
                                if (resultsD2[i] == 1) {
                                    ones.add(resultsD2[i]);
                                    numFails++;
                                } else if (resultsD2[i] == 2) {
                                    crit.add(resultsD2[i]);
                                    numCrits++;
                                }
                                resultList.add("D2  #" + (i + 1) + ":  " + resultsD2[i]);
                                totalResult += resultsD2[i];
                            }
                            numRolls += resultsD2.length;
                        }
                        int resultsD4[] = rollDice(numD4, 4);
                        if (resultsD4.length > 0) {
                            for (int i = 0; i < resultsD4.length; i++) {
                                if (resultsD4[i] == 1) {
                                    ones.add(resultsD4[i]);
                                    numFails++;
                                } else if (resultsD4[i] == 4) {
                                    crit.add(resultsD4[i]);
                                    numCrits++;
                                }
                                resultList.add("D4  #" + (i + 1) + ":  " + resultsD4[i]);
                                totalResult += resultsD4[i];
                            }
                            numRolls += resultsD4.length;
                        }
                        int resultsD6[] = rollDice(numD6, 6);
                        if (resultsD6.length > 0) {
                            for (int i = 0; i < resultsD6.length; i++) {
                                if (resultsD6[i] == 1) {
                                    ones.add(resultsD6[i]);
                                    numFails++;
                                } else if (resultsD6[i] == 6) {
                                    crit.add(resultsD6[i]);
                                    numCrits++;
                                }
                                resultList.add("D6  #" + (i + 1) + ":  " + resultsD6[i]);
                                totalResult += resultsD6[i];
                            }
                            numRolls += resultsD6.length;
                        }
                        int resultsD8[] = rollDice(numD8, 8);
                        if (resultsD8.length > 0) {
                            for (int i = 0; i < resultsD8.length; i++) {
                                if (resultsD8[i] == 1) {
                                    ones.add(resultsD8[i]);
                                    numFails++;
                                } else if (resultsD8[i] == 8) {
                                    crit.add(resultsD8[i]);
                                    numCrits++;
                                }
                                resultList.add("D8  #" + (i + 1) + ":  " + resultsD8[i]);
                                totalResult += resultsD8[i];
                            }
                            numRolls += resultsD8.length;
                        }
                        int resultsD10[] = rollDice(numD10, 10);
                        if (resultsD10.length > 0) {
                            for (int i = 0; i < resultsD10.length; i++) {
                                if (resultsD10[i] == 1) {
                                    ones.add(resultsD10[i]);
                                    numFails++;
                                } else if (resultsD10[i] == 10) {
                                    crit.add(resultsD10[i]);
                                    numCrits++;
                                }
                                resultList.add("D10 #" + (i + 1) + ":  " + resultsD10[i]);
                                totalResult += resultsD10[i];
                            }
                            numRolls += resultsD10.length;
                        }
                        int resultsD12[] = rollDice(numD12, 12);
                        if (resultsD12.length > 0) {
                            for (int i = 0; i < resultsD12.length; i++) {
                                if (resultsD12[i] == 1) {
                                    ones.add(resultsD12[i]);
                                    numFails++;
                                } else if (resultsD12[i] == 12) {
                                    crit.add(resultsD12[i]);
                                    numCrits++;
                                }
                                resultList.add("D12 #" + (i + 1) + ":  " + resultsD12[i]);
                                totalResult += resultsD12[i];
                            }
                            numRolls += resultsD12.length;
                        }
                        int resultsD20[] = rollDice(numD20, 20);
                        if (resultsD20.length > 0) {
                            for (int i = 0; i < resultsD20.length; i++) {
                                if (resultsD20[i] == 1) {
                                    ones.add(resultsD20[i]);
                                    numFails++;
                                } else if (resultsD20[i] == 20) {
                                    crit.add(resultsD20[i]);
                                    numCrits++;
                                }
                                resultList.add("D20 #" + (i + 1) + ":  " + resultsD20[i]);
                                totalResult += resultsD20[i];
                            }
                            numRolls += resultsD20.length;
                        }
                        int resultsD50[] = rollDice(numD50, 50);
                        if (resultsD50.length > 0) {
                            for (int i = 0; i < resultsD50.length; i++) {
                                if (resultsD50[i] == 1) {
                                    ones.add(resultsD50[i]);
                                    numFails++;
                                } else if (resultsD50[i] == 50) {
                                    crit.add(resultsD50[i]);
                                    numCrits++;
                                }
                                resultList.add("D50 #" + (i + 1) + ":  " + resultsD50[i]);
                                totalResult += resultsD50[i];
                            }
                            numRolls += resultsD50.length;
                        }
                        int resultsD100[] = rollDice(numD100, 100);
                        if (resultsD100.length > 0) {
                            for (int i = 0; i < resultsD100.length; i++) {
                                if (resultsD100[i] == 1) {
                                    ones.add(resultsD100[i]);
                                    numFails++;
                                } else if (resultsD100[i] == 100) {
                                    crit.add(resultsD100[i]);
                                    numCrits++;
                                }
                                resultList.add("D100 #" + (i + 1) + ":  " + resultsD100[i]);
                                totalResult += resultsD100[i];
                            }
                        }
                        numRolls += resultsD100.length;
                    } else {
                        int[] results = rollDice(Integer.parseInt(dice.getText().toString()), Integer.parseInt(sides.getSelectedItem().toString()));
                        for (int i = 0; i < results.length; i++) {
                            if (results[i] == 1) {
                                ones.add(results[i]);
                                numFails++;
                            } else if (results[i] == Integer.parseInt(sides.getSelectedItem().toString())) {
                                crit.add(results[i]);
                                numCrits++;
                            }
                            resultList.add("D" + Integer.parseInt(sides.getSelectedItem().toString()) + "  #" + (i + 1) + ":  " + results[i]);
                            totalResult += results[i];
                        }
                        numRolls += results.length;

                    }


                    resultsAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, resultList) {
                        @Override
                        public View getView(int position, View convertView, ViewGroup parent) {

                            View view = super.getView(position, convertView, parent);
                            TextView text = (TextView) view.findViewById(android.R.id.text1);
                            int length = text.length();
                            int diceValue = Integer.parseInt(text.getText().toString().substring(1, 4).replaceAll("\\s", ""));

                            if (Integer.parseInt(text.getText().toString().substring(length - 3, length).replaceAll("\\s", "")) == 1) {
                                text.setTextColor(Color.parseColor("#FF0057"));
                            } else if (Integer.parseInt(text.getText().toString().substring(length - 3, length).replaceAll("\\s", "")) == diceValue) {
                                text.setTextColor(Color.parseColor("#00C853"));
                            } else {
                                text.setTextColor(Color.parseColor("#616161"));
                            }

                            return view;
                        }
                    };

                    list.setAdapter(resultsAdapter);
                    average = (double) totalResult / numRolls;
                    total.setText("Total Result: " + totalResult);
                    crits.setText("Crits: " + numCrits);
                    fails.setText("Failures: " + numFails);
                    averageText.setText(String.format("Average: %.2f", average));
                    diceSelected = false;
                    numD2 = 0;
                    numD4 = 0;
                    numD6 = 0;
                    numD8 = 0;
                    numD10 = 0;
                    numD12 = 0;
                    numD20 = 0;
                    numD50 = 0;
                    numD100 = 0;
                } else {
                    Toast.makeText(getApplicationContext(), "Enter a number of dice between 1 and 999",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        addDiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(dice.getText().toString()) > 0 && Integer.parseInt(dice.getText().toString()) < 1000) {


                    if (diceSelected == false) {
                        diceSelected = true;
                    }
                    switch (Integer.parseInt(sides.getSelectedItem().toString())) {
                        case 2:
                            numD2 += Integer.parseInt(dice.getText().toString());
                            Toast.makeText(getApplicationContext(), "" + dice.getText().toString() + " D2 added to roll",
                                    Toast.LENGTH_SHORT).show();
                            break;
                        case 4:
                            numD4 += Integer.parseInt(dice.getText().toString());
                            Toast.makeText(getApplicationContext(), "" + dice.getText().toString() + " D4 added to roll",
                                    Toast.LENGTH_SHORT).show();
                            break;
                        case 6:
                            numD6 += Integer.parseInt(dice.getText().toString());
                            Toast.makeText(getApplicationContext(), "" + dice.getText().toString() + " D6 added to roll",
                                    Toast.LENGTH_SHORT).show();
                            break;
                        case 8:
                            numD8 += Integer.parseInt(dice.getText().toString());
                            Toast.makeText(getApplicationContext(), "" + dice.getText().toString() + " D8 added to roll",
                                    Toast.LENGTH_SHORT).show();
                            break;
                        case 10:
                            numD10 += Integer.parseInt(dice.getText().toString());
                            Toast.makeText(getApplicationContext(), "" + dice.getText().toString() + " D10 added to roll",
                                    Toast.LENGTH_SHORT).show();
                            break;
                        case 12:
                            numD12 += Integer.parseInt(dice.getText().toString());
                            Toast.makeText(getApplicationContext(), "" + dice.getText().toString() + " D12 added to roll",
                                    Toast.LENGTH_SHORT).show();
                            break;
                        case 20:
                            numD20 += Integer.parseInt(dice.getText().toString());
                            Toast.makeText(getApplicationContext(), "" + dice.getText().toString() + " D20 added to roll",
                                    Toast.LENGTH_SHORT).show();
                            break;
                        case 50:
                            numD50 += Integer.parseInt(dice.getText().toString());
                            Toast.makeText(getApplicationContext(), "" + dice.getText().toString() + " D50 added to roll",
                                    Toast.LENGTH_SHORT).show();
                            break;
                        case 100:
                            numD100 += Integer.parseInt(dice.getText().toString());
                            Toast.makeText(getApplicationContext(), "" + dice.getText().toString() + " D100 added to roll",
                                    Toast.LENGTH_SHORT).show();
                            break;
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Enter a number of dice between 1 and 999",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public int[] rollDice(int numDice, int numSided) {
        Random random = new Random();
        int[] results = new int[numDice];
        for(int i = 0; i< numDice; i++) {
            results[i] = random.nextInt((numSided)) + 1;
        }

        return results;
    }
}
