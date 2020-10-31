 
class Nqueens 
{ 
static int N = 4; 
  

static int []moves = new int[30]; 

static int []row= new int[30]; 

static int []column= new int[30]; 
  

static void printSolution(int board[][]) 
{ 
    for (int i = 0; i < N; i++) 
    { 
        for (int j = 0; j < N; j++) 
            System.out.printf(" %d ", board[i][j]); 
        System.out.printf("\n"); 
    } 
} 

static boolean solveNQUtil(int board[][], int col) 
{ 

    if (col >= N) 
        return true; 

    for (int i = 0; i < N; i++) 
    { 
          

        if ((moves[i - col + N - 1] != 1 && 
             row[i + col] != 1) && column[i] != 1) 
        { 

            board[i][col] = 1; 
            moves[i - col + N - 1] = 
            row[i + col] = column[i] = 1; 

            if (solveNQUtil(board, col + 1)) 
                return true; 

            moves[i - col + N - 1] = 
            row[i + col] = column[i] = 0; 
        } 
    } 

    return false; 
} 

static boolean solveNQuens() 
{ 
    int board[][] = {{ 0, 0, 0, 0 }, 
                     { 0, 0, 0, 0 }, 
                     { 0, 0, 0, 0 }, 
                     { 0, 0, 0, 0 }}; 
  
    if (solveNQUtil(board, 0) == false)  
    { 
        System.out.printf("Solution does not exist"); 
        return false; 
    } 
  
    printSolution(board); 
    return true; 
} 
  

public static void main(String[] args) 
{ 
    solveNQuens(); 
} 
}
