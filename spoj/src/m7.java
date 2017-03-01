import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class m7
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = bf.readLine();
		int t = Integer.parseInt(line);
		Bulk b = new Bulk();
		while (t-->0)
		{
			b.initialize(bf);
			System.out.println("The bulk is composed of "+b.getVolume() +" units.");
		}
	}
	
	static class Bulk
	{
		/** a face unit is a face of a unit.
		/* It is described by its middle point in the 3D space, e.g. 0.5,0.5,1
		/* One coord is integer while the other two are [someinteger].5
		*/
		ArrayList<Point> faceUnits = new ArrayList<Point>();
        static ArrayList<Point> borders = new ArrayList<Point>();

		public Bulk()
		{
		}
		
		public void initialize(BufferedReader bf)throws Exception
		{
            faceUnits.clear();
			
			String line = bf.readLine();
			int faces = Integer.parseInt(line);
			while(faces -->0)
			{
				line = bf.readLine();
				addFace(line);
			}
		}
		
		private void addFace(String face)
		{
            borders.clear();
			String[] data = face.split("  ");
			int nPoints = Integer.parseInt(data[0]);
			Point first = parsePoint(data[1]);
			Point from, to = first;
			for(int i = 2; i<nPoints+1; i++)
			{
				from = to;				
				to = parsePoint(data[i]);
				if (to.X != from.X ) return; // we only consider faces in same X axis
				// we only consider borders in the Y direction (i.e. same Y)
                if (to.Y == from.Y) addBorder(from, to, borders);
			}
			from = to;
			to = first;
            if (to.Y == from.Y ) addBorder(from, to, borders);
			addFaceUnits(borders);
		}
		
		private Point parsePoint(String point)
		{
			String[] coords = point.split(" ");
			Point p = new Point();
			p.X = Integer.parseInt(coords[0]);
			p.Y = Integer.parseInt(coords[1]);
			p.Z = Integer.parseInt(coords[2]);
			return p;
		}
		
		private void addBorder(Point from, Point to, ArrayList<Point> borders)
		{
			// a border is the border of a unit,
			// it is described by the middle point of the line, e.g. (0.5, 0, 0) is the first border starting from 0,0,0 in the X direction
			
			// both points have two coordinates equal and one different
			int start 	= (int) ((from.X != to.X) ? Math.min(from.X, to.X) : 0); 
			int finish 	= (int) ((from.X != to.X) ? Math.max(from.X, to.X) : 0);
			start 		= (int) ((from.Y != to.Y) ? Math.min(from.Y, to.Y) : start); 
			finish 		= (int) ((from.Y != to.Y) ? Math.max(from.Y, to.Y) : finish); 
			start 		= (int) ((from.Z != to.Z) ? Math.min(from.Z, to.Z) : start); 
			finish 		= (int) ((from.Z != to.Z) ? Math.max(from.Z, to.Z) : finish);  
			
			while (start < finish)
			{			
				double X = (from.X == to.X)?from.X: start+0.5;
				double Y = (from.Y == to.Y)?from.Y: start+0.5;
				double Z = (from.Z == to.Z)?from.Z: start+0.5;
				borders.add(new Point(X,Y,Z));
				start++;
			}
		}

        /**
         * The borders must be of a plane in the X axis, i.e. borders share a common X
         * Then, the faces are in the X plane.
         *
         * @param borders
         */
		private void addFaceUnits(ArrayList<Point> borders)
		{
			if (borders.size() == 0) return;
            int x = (int) borders.get(0).X;
			boolean inside =true;
            Collections.sort(borders);

            Point previousBorder = borders.get(0), currentBorder;
            for (int i = 1; i < borders.size(); i++) {
                currentBorder = borders.get(i);
                if (previousBorder.Z != currentBorder.Z) {
                    // change of row
                    inside = true;
                } else {
                    if (inside) {
                        // add all faces up to here
                        for (double y = previousBorder.Y; y < currentBorder.Y; y++) {
                                faceUnits.add(new Point(currentBorder.X, y+.5, currentBorder.Z));
                        }
                    }
                    inside = !inside;
                }
                previousBorder = currentBorder;
            }
		}

        /**
         * The faces are in the X plane.
         * We want to search per row, where a row keeps Y and Z, and changes X.
         * We want the faces in the row ordered from lower X to higher X
         * @return
         */
		private int getVolume() {
            // find one inside unit
            if (faceUnits.size() == 0) return 0;
            Collections.sort(faceUnits);
            int volume = 0;
            boolean inside = true;

            Point previousFace = faceUnits.get(0), currentFace;
            // we move from bottom to up (this is incrementing z)
            // then move to the next column (this is increment y)
            // and finally the x plane
            for (int i = 1; i < faceUnits.size(); i++) {
                currentFace = faceUnits.get(i);
                if (previousFace.Y != currentFace.Y) {
                    // change of row
                    inside = true;
                } else {
                    if (inside) {
                        // add the number of blocks between the faces
                        volume += (currentFace.X - previousFace.X);
                    }
                    inside = !inside;
                }
                previousFace = currentFace;
            }

            return volume;
        }
    }
	
	static class Point implements Comparable<Point> {
		public double X, Y, Z;
		public Point ()
		{}
		
		public Point (double X, double Y, double Z)
		{
			this.X = X;
			this.Y = Y;
			this.Z = Z;
		}
		public boolean equals(Object obj)
		{
            //System.out.println("testing equals: "+this+" and "+obj);
            if (!(obj instanceof Point)) return false;
            Point p = (Point) obj;
			if (p == null) return false;
			if (p == this) return true;
			return (this.X == p.X && this.Y == p.Y && this.Z == p.Z);
		}
        public int hashCode() {
            long x = Double.doubleToLongBits(X);
            long y = Double.doubleToLongBits(Y);
            long z = Double.doubleToLongBits(Z);
            int result = 17;
            result = 37 * result + (int) (x ^ (x >> 32));
            result = 37 * result + (int) (y ^ (y >> 32));
            result = 37 * result + (int) (z ^ (z >> 32));
            return result;
        }
        public String toString()
		{
			return X+" "+Y+" "+Z;
		}

        @Override
        public int compareTo(Point o) {
            if (Z < o.Z) return -1;
            if (Z > o.Z) return 1;
            if (Y < o.Y) return -1;
            if (Y > o.Y) return 1;
            if (X < o.X) return -1;
            if (X > o.X) return 1;
            return 0;
        }
    }
}