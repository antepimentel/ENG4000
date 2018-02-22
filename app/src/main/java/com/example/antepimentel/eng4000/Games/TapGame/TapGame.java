package com.example.antepimentel.eng4000.Games.TapGame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.example.antepimentel.eng4000.Data.Helper;

/**
 * Created by Ante Pimentel on 1/20/2018.
 */

public class TapGame extends View {

    float x,y,xPrev,yPrev = 0;
    int powerLevel = 0;
    int windowHeight, windowWidth = 0;

    int numRows = 4;
    int numColumns = 4;

    int verticalOffset = 100;
    int vBuff = 20;
    int hBuff = 10;
    int gridHeight = (Helper.getScreenHeight() - verticalOffset ) /5;
    int gridWidth = Helper.getScreenWidth()/4;

    private Paint pOff = new Paint();
    private Paint pOn = new Paint();

    private LightSwitch[][] gameBoard = new LightSwitch[numRows][numColumns];

    // Variables that affect the speed of gameplay
    int rateOfPowerIncrease = 0;
    int rateOfLightChange = 0;

    public TapGame(Context context, int wWidth, int wHeight) {
        super(context);

        initGameBoard();
        pOff.setColor(Color.BLUE);
        pOn.setColor(Color.GREEN);

        windowHeight = wHeight;
        windowWidth = wWidth;

    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numColumns; j++){
                float tempX = (float) (i * gridWidth);
                float tempY = (float) (j * gridHeight) + verticalOffset;

                Paint tempPaint = pOff;
                if(gameBoard[j][i].getIsOn()){ // I feel like this SHOULD be gameBoard[i][j], but its not
                    tempPaint = pOn;
                }
                canvas.drawRect(tempX + hBuff,
                                tempY + vBuff,
                                tempX + gridWidth - hBuff,
                                tempY + gridHeight - vBuff,
                                tempPaint);
            }
        }
        invalidate();
    }

    //TODO: Add touch listener thread to detect which square is pressed
    @Override
    public boolean onTouchEvent(MotionEvent event){

        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            x = event.getX();
            y = event.getY();

            // Which column was pressed - X
            int column = (int) Math.floor((double) x / gridWidth);

            // Which row was pressed - Y
            int row = (int) Math.floor((double) (y - verticalOffset) / gridHeight);

            if (column >= 0 && column <= 3) {
                if (row >= 0 && row <= 3) {
                    gameBoard[row][column].setIsOn(!gameBoard[row][column].getIsOn());

                }
            }

            System.out.println("TOUCH EVENT: " + column + " " + row);
            String temp = "";

            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    if(gameBoard[i][j].getIsOn()){
                        System.out.print(" O");
                    } else {
                        System.out.print(" X");
                    }
                }
                System.out.println();
            }
        }
        return true;
    }

    private void initGameBoard(){
        int i, j;
        for(i = 0; i < numRows; i++){
            for(j = 0; j < numColumns; j++){
                gameBoard[i][j] = new LightSwitch();
            }
        }
    }

    //TODO: Add thread to randomize the color of the squares

}
