public class Time{
	public String whatTime(int seconds){
		return String.valueOf(((seconds / 60) / 60) % 60 + ":"+ ((seconds / 60) % 60) + ":" + seconds % 60);
	}
}