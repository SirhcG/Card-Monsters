package HW3;
//Huaqing Liu
//this class structure detail of each level
import cardmonsters.MonsterPlayer;
public class Level {

	private MonsterPlayer op; //essentially, each level will have one opponent;
	
	public Level()
	{
		op = null;
	}
	public Level(MonsterPlayer op)
	{
		this.op = op;
	}
	
	public MonsterPlayer getOP()
	{
		return this.op;
	}
	
	public void setOP(MonsterPlayer op)
	{
		this.op = op;
	}
}
