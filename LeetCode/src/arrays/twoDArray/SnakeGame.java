package arrays.twoDArray;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SnakeGame {
    Map<Cell,Boolean> snakeMap;
    Deque<Cell> snake;
    int width;
    int height;
    int[][] food;
    int foodIndex;
    public SnakeGame(int width,int height,int[][] food){
        this.width = width;
        this.height = height;
        this.food = food;
        this.snakeMap = new HashMap<>();
        snakeMap.put(new Cell(0,0),true);
        this.snake = new LinkedList<>();
        snake.add(new Cell(0,0));
    }
    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        Cell snakeCell = this.snake.peekFirst();
        int newHeadRow = snakeCell.x;
        int newHeadColumn = snakeCell.y;
        switch (direction) {
            case "U":
                newHeadRow --;
                break;
            case "D":
               newHeadRow ++;
               break;
            case "L":
                newHeadColumn --;
                break;
            case "R":
                newHeadColumn ++;
                break;
        }
        Cell newHead = new Cell(newHeadRow,newHeadColumn);
        Cell currentTail = this.snake.peekLast();

        //Boundry Conditions
        if(newHead.x < 0 || newHead.x > this.width || newHead.y < 0 || newHead.y > this.height)
            return -1;

        //Checking if the snake bites itself
        if(this.snakeMap.containsKey(newHead) || !(newHead.x == currentTail.x && newHead.y == currentTail.y)) {
            return -1;
        }

        // If there's an available food item and it is on the cell occupied by the snake after the move, eat it.
        if((this.foodIndex < this.food.length) && (this.food[this.foodIndex][0] == newHeadRow)
                && (this.food[this.foodIndex][1] == newHeadColumn)) {
            this.foodIndex ++;
        }
        else {
            this.snake.pollLast();
            this.snakeMap.remove(currentTail);
        }
        this.snake.addFirst(newHead);
        this.snakeMap.put(newHead , true);
        return this.snake.size() - 1;
    }
}

class Cell {
    int x;
    int y;
    Cell(int x,int y) {
        this.x = x;
        this.y = y;
    }
}
