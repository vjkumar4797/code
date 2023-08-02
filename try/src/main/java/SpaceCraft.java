public class SpaceCraft {
	int quadrant;
	int[] position;
	Character direction;

	public SpaceCraft(int[] position, Character direction) {
		this.position = position;
		this.direction = direction;
		switch (direction) {
		case 'E':
		case 'W':
			this.quadrant = 0;
			break;
		case 'N':
		case 'S':
			this.quadrant = 1;
			break;
		case 'U':
		case 'D':
			this.quadrant = 2;
			break;
		default:
		}
	}

	public Character getDirection() {
		return direction;
	}

	public int[] getPosition() {
		return position;
	}

	public void updatePositionAndDirection(Character cmd) {
		switch (this.direction) {
		case 'N':
			switch (cmd) {
			case 'l':
				this.direction = 'W';
				this.quadrant = 0;
				break;
			case 'r':
				this.direction = 'E';
				this.quadrant = 0;
				break;
			case 'u':
				this.direction = 'U';
				this.quadrant = 2;
				break;
			case 'd':
				this.direction = 'D';
				this.quadrant = 2;
				break;
			case 'f':
				this.position[this.quadrant]++;
				break;
			case 'b':
				this.position[this.quadrant]--;
				break;
			default:
			}
			break;
		case 'S':
			switch (cmd) {
			case 'l':
				this.direction = 'E';
				this.quadrant = 0;
				break;
			case 'r':
				this.direction = 'W';
				this.quadrant = 0;
				break;
			case 'u':
				this.direction = 'U';
				this.quadrant = 2;
				break;
			case 'd':
				this.direction = 'D';
				this.quadrant = 2;
				break;
			case 'f':
				this.position[this.quadrant]--;
				break;
			case 'b':
				this.position[this.quadrant]++;
				break;
			default:
			}
			break;
		case 'E':
			switch (cmd) {
			case 'l':
				this.direction = 'N';
				this.quadrant = 1;
				break;
			case 'r':
				this.direction = 'S';
				this.quadrant = 1;
				break;
			case 'u':
				this.direction = 'U';
				this.quadrant = 2;
				break;
			case 'd':
				this.direction = 'D';
				this.quadrant = 2;
				break;
			case 'f':
				this.position[this.quadrant]++;
				break;
			case 'b':
				this.position[this.quadrant]--;
				break;
			}
			break;
		case 'W':
			switch (cmd) {
			case 'l':
				this.direction = 'S';
				this.quadrant = 1;
				break;
			case 'r':
				this.direction = 'N';
				this.quadrant = 1;
				break;
			case 'u':
				this.direction = 'U';
				this.quadrant = 2;
				break;
			case 'd':
				this.direction = 'D';
				this.quadrant = 2;
				break;
			case 'f':
				this.position[this.quadrant]--;
				break;
			case 'b':
				this.position[this.quadrant]++;
				break;
			}
			break;
		case 'U':
			switch (cmd) {
			case 'l':
				this.direction = 'W';
				this.quadrant = 0;
				break;
			case 'r':
				this.direction = 'E';
				this.quadrant = 0;
				break;
			case 'u':
				this.direction = 'S';
				this.quadrant = 1;
				break;
			case 'd':
				this.direction = 'N';
				this.quadrant = 1;
				break;
			case 'f':
				this.position[this.quadrant]++;
				break;
			case 'b':
				this.position[this.quadrant]--;
				break;
			default:
			}
			break;
		case 'D':
			switch (cmd) {
			case 'l':
				this.direction = 'W';
				this.quadrant = 0;
				break;
			case 'r':
				this.direction = 'E';
				this.quadrant = 0;
				break;
			case 'u':
				this.direction = 'N';
				this.quadrant = 1;
				break;
			case 'd':
				this.direction = 'S';
				this.quadrant = 1;
				break;
			case 'f':
				this.position[this.quadrant]--;
				break;
			case 'b':
				this.position[this.quadrant]++;
				break;
			default:
			}
		}
	}

}
