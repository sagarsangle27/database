
interface Game
{
	void play();
}

class Cricket implements Game
{
	public void play()
	{
		System.out.println("playing cricket");
	}
}

class Football implements Game
{
	public void play()
	{
		System.out.println("playing football");
	}
}

class Tennis implements Game
{
	public void play()
	{
		System.out.println("playing tennis");
	}
}

class Gen<T extends Game>
{
	private T gameObject;

	public Gen(T gameObject) {
		super();
		this.gameObject = gameObject;
	}

    public void  gamePlay()
    {
    	gameObject.play();
    }


}


public class Que3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Gen<Game> g1=new Gen(new Cricket());
		Gen<Game> g2=new Gen(new Football());
		Gen<Game> g3=new Gen(new Tennis());
		g1.gamePlay();
		g2.gamePlay();
		g3.gamePlay();
		
		
		
		
		
	}

}
