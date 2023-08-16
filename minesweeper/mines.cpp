#include <iostream>
#include <cstdlib>
#include <vector>
#include <string>
#include <set>
//#include <pair>
#include <random>

using namespace std;

int count_bombs(vector<vector<char>> &board, int i, int j){
    int n=board.size();
    int m=board[0].size();
    int count=0;
    
    if(i-1>=0 && board[i-1][j]=='*')
      count++;
    
    if(i+1<n && board[i+1][j]=='*')
      count++;
    
    if(j-1>=0 && board[i][j-1]=='*')
      count++;
    
    if(j+1<m && board[i][j+1]=='*')
      count++;  
    
    if(i-1>=0 && j-1>=0 && board[i-1][j-1]=='*')
      count++;
    
    if(i-1>=0 && j+1<m && board[i-1][j+1]=='*')
      count++;
    
    if(i+1<n && j-1>=0 && board[i+1][j-1]=='*')
      count++;
    
    if(i+1<n && j+1<m && board[i+1][j+1]=='*')
      count++; 

    //cout << "count = " << count << endl;       
    
    return count;
} 

void generate(vector<vector<char>>& board, int total){
    int n=board.size();
    int m=board[0].size();
    int count=0; 
    set<pair<int, int>> used;
    while(count<total){
        int i=rand() % n;
        int j=rand() % m;
        if(used.find(make_pair(i, j))==used.end()){
            used.insert(make_pair(i, j));
            board[i][j]='*';
            count++;
        }
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(board[i][j]!='*'){
                board[i][j]='0'+count_bombs(board, i, j);
            }
        }
    }
}

void print_board(vector<vector<char>> &board){
    int n=board.size();
    int m=board.size();
    cout << "-";
    
    for(int i=0;i<m;i++){
        cout << "----";
    }

    cout << endl;
    for(int i=0;i<n;i++){
        cout << "| ";
        for(int j=0;j<m;j++){
           cout << board[i][j] << " | ";
        }
        cout << "\n-";
    
        for(int i=0;i<m;i++){
           cout << "----";
        }

        cout << endl;
    }

}

void show_other_free_fields(vector<vector<char>>& board, vector<vector<char>>& display_board, int x, int y, vector<vector<bool>>& visited){
    int n=board.size();
    int m=board[0].size();
    if(x<0 || x>=n || y<0 || y>=m)
      return;
    
    visited[x][y]=true;
    
    if(board[x][y]=='*' || board[x][y]=='!' || board[x][y]=='?')
      return;

    display_board[x][y]=board[x][y];
    //cout << "Hey there VV1!" << endl;
    
    if(x+1<n && !visited[x+1][y])
      show_other_free_fields(board, display_board, x+1, y, visited); 
    
    //cout << "I have gotten you!" << endl;
    if(x-1>=0 && !visited[x-1][y])
      show_other_free_fields(board, display_board, x-1, y, visited);
    
    if(y-1>=0 && !visited[x][y-1])
      show_other_free_fields(board, display_board, x, y-1, visited);
    
    if(y+1<m && !visited[x][y+1])
      show_other_free_fields(board, display_board, x, y+1, visited);
    
    if(x+1<n && y+1<m && !visited[x+1][y+1])
      show_other_free_fields(board, display_board, x+1, y+1, visited);
    
    if(x+1<n && y-1>=0 && !visited[x+1][y-1])
      show_other_free_fields(board, display_board, x+1, y-1, visited);
    
    if(x-1>=0 && y-1>=0 && !visited[x-1][y-1])
      show_other_free_fields(board, display_board, x-1, y-1, visited);
    
    if(x-1>=0 && y+1<m && !visited[x-1][y+1])
      show_other_free_fields(board, display_board, x-1, y+1, visited); 
}

bool check_click(vector<vector<char>>& board, vector<vector<char>>& display_board, int x, int y){
    int n=board.size();
    int m=board[0].size();
    //cout << "Hey there!" << endl;
    if(board[x][y]=='*' && display_board[x][y]!='!')
      return false;

    if(board[x][y]=='*' && display_board[x][y]=='!')
      return true;  
    
    //cout << "Hey there V2!" << endl;
    display_board[x][y]=board[x][y];
    //cout << "Hey there V3!" << endl;

    vector<vector<bool>> visited(n, vector<bool>(m));
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            visited[i][j]=false;
        }
    }

    if(board[x][y]=='0')
      show_other_free_fields(board, display_board, x, y, visited);
    //cout << "Hey there V4!" << endl;

    return true;  
}

bool check_hit(vector<vector<char>>& board, vector<vector<char>>& display_board, int x, int y){
    display_board[x][y]='!';
    if(board[x][y]=='*')
      return true;
    else
      return false;  
}


int main(){

    int n;
    int m;
    int game;
    int num_of_bombs;
    srand(time(0));
    cout << "Welcome to our short C++ terminal games!" << endl;
    cout << "Here is the list of the game you can play here:" << endl;
    cout << "1 - MineSweeper" << endl;
    cout << "2 - Snake" << endl;
    cout << "Tell us what game would you like to play by typing one of the given numbers (1 or 2): " << endl;
    cin >> game;
    /*
    if(game==1)
      goto Minesweeper;
    else if(game==2)
      goto Snake;
    else {
      cout << "There isn't such a game! Try again next time!" << endl;
      exit(EXIT_FAILURE);  
    }
    */    
    
    if(game==1){
        //Minesweeper:
        cout << "First we need you to enter the size of minesweeper table: " << endl;
        cin >> n >> m;
        cout << "Now enter the number of bombs you would like to have hiden across the table: " << endl;
        cin >> num_of_bombs;
        vector<vector<char>> board(n, vector<char>(m));
        vector<vector<char>> display_board(n, vector<char>(m));
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                board[i][j]='0';
                display_board[i][j]=' ';
            }
        }
        generate(board, num_of_bombs);
        cout << "-------------------------------------------------------------------" << endl;
        cout << "We can now start the game!" << endl;
        cout << "If you want to open some tile on the board press 1 following the coordinates of the desired tile!" << endl;
        cout << "If you want to mark a bomb on the board press 2 following the coordinates of the bomb!" << endl;
        bool game_state=true;
        int hits=0;
        int x;
        int y;
        int option;
        while(game_state){
            cin >> option >> x >> y;
            if(option==1){
            if(x<0 || x>=n || y<0 || y>=m){
                cout << "Coordinates of the desired tile are out of range! Please, try again!" << endl;
                continue;
            } else {
                bool flag=check_click(board, display_board, x, y);
                cout << "Here?!" << endl;
                if(!flag){
                    cout << "You have hit the bomb! :/ :(" << endl;
                    cout << "The game is over! See you next time!" << endl;
                    game_state=false;
                    continue;
                } else {
                    cout << "The is how your board looks like now!" << endl;
                    print_board(display_board);
                }
            }
                
            } else if(option==2){
            if(x<0 || x>=n || y<0 || y>=m){
                cout << "Coordinates of the desired tile are out of range! Please, try again!" << endl;
                continue;
            } else {
                bool flag=check_hit(board, display_board, x, y);
                if(flag)
                hits++;
                print_board(display_board);
            }  
            } else {
            cout << "That's not the right option! Check out out instuction above!" << endl;  
            }

        }
        //print_board(board);
    } else if(game==2){
        //Snake 
        cout << "Enter the snake size: " << endl;
        
    }


//Snake: 
//cout << "How was the jump? Did you enjoy it?\n";

    return 0;
}