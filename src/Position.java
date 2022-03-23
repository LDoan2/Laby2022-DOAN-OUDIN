public class Position {

    private int x,y;

    public Position(int cx, int cy){
        this.x = cx;
        this.y = cy;
    }
    public int getX(){
        return this.x;
    }

    public int getY() {
        return y;
    }

    public void avancerX(){
        this.x +=1;
    }

    public void avancerY(){
        this.y +=1;
    }

    public void reculerX(){
        this.x = this.x - 1;
    }

    public void reculerY(){
        this.y = this.y - 1;
    }
}
