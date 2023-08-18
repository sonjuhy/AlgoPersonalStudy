package backjoon;

import java.io.*;
import java.util.*;

public class BJ_20006 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int P = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Room> rooms = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		for(int p=0;p<P;p++) {
			st = new StringTokenizer(br.readLine());
			int level = Integer.parseInt(st.nextToken());
			String user = st.nextToken();
			if(rooms.size() == 0) {
				Room room = new Room(level, M);
				room.people.add(new User(level, user));
				rooms.add(room);
			}
			else {
				boolean join = true;
				for(int i=0;i<rooms.size();i++) {
					Room room = rooms.get(i);
					if(Math.abs(room.level - level) > 10) continue;
					if(room.personCount >= M) continue;
					room.people.add(new User(level, user));
					room.personCount += 1;
					join = false;
					break;
				}
				if(join) {
					Room room = new Room(level, M);
					room.people.add(new User(level, user));
					rooms.add(room);
				}
			}
		}
		for(int r=0;r<rooms.size();r++) {
			Room room = rooms.get(r);
			room.people.sort(Comparator.naturalOrder());
			if(room.personCount == M) {
				sb.append("Started!\n");
				for(int m=0;m<M;m++) {
					sb.append(room.people.get(m).level+" "+room.people.get(m).name+"\n");
				}
			}
			else {
				sb.append("Waiting!\n");
				for(int m=0;m<room.personCount;m++) {
					sb.append(room.people.get(m).level+" "+room.people.get(m).name+"\n");
				}
			}
		}
		System.out.println(sb.toString());
	}
	static class Room{
		int level;
		int personCount;
		ArrayList<User> people = new ArrayList<>();
		
		public Room() {}
		public Room(int level, int personCount) {
			this.level = level;
			this.personCount = 1;
		}
	}
	static class User implements Comparable<User>{
		int level;
		String name;
		public User() {}
		public User(int level, String name) {
			this.level = level;
			this.name = name;
		}
		@Override
		public int compareTo(User o) {
			// TODO Auto-generated method stub
			if(this.name.compareTo(o.name) <= 0) return -1;
			else return 1;
		}
	}
}
