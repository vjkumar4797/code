public class Solution {

	public static void main(String[] args) {
		int[] position = {0,0,0};
		Character direction = 'N';
		SpaceCraft chandrayaan3 = new SpaceCraft(position,direction);
		Character[] cmds = {'f','r','u','b','l'};
		for(Character cmd : cmds) {
			chandrayaan3.updatePositionAndDirection(cmd);
		}
		System.out.println("Direction : " + chandrayaan3.getDirection());
		StringBuilder sb = new StringBuilder();
		sb.append("Position : (");
		for(int x : chandrayaan3.getPosition()) {
			sb.append(x);
			sb.append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append(")");
		System.out.println(sb.toString());
	}


}
