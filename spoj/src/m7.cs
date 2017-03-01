using java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
		
		public Bulk()
		{
		}
		
		public void initialize(BufferedReader bf)throws Exception
		{
            faceUnits = new ArrayList<Point>();			
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
			String[] data = face.split("  ");
			int nPoints = Integer.parseInt(data[0]);
			ArrayList<Point> borders = new ArrayList<Point>();
			Point first = parsePoint(data[1]);
			Point from = first, to = first;
			int axis = 6;
			for(int i = 2; i<nPoints+1; i++)
			{
				from = to;				
				to = parsePoint(data[i]);
				if (to.X != from.X ) return; // we only consider faces in same X axis
				addBorder(from, to, borders);
			}
			from = to;
			to = first;
			addBorder(from, to, borders);
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
         *
         * @param borders
         */
		private void addFaceUnits(ArrayList<Point> borders)
		{
			if (borders.size() == 0) return;
            int x = (int) borders.get(0).X;
			boolean inside =false;
            for (double y = 0.5; y < 1000; y++) {
                for (double z = 0; z < 1000; z++) {
                    if (borders.contains(new Point(x,y,z))) {
                        inside = !inside;
                    }
                    if (inside)
                    {
                        faceUnits.add(new Point(x,y,z+.5));
                    }
                }
            }
		}

		private int getVolume() {
            // find one inside unit
            if (faceUnits.size() == 0) return 0;
            int volume = 0;
            boolean inside;
            for (double z = 0.5; z < 1000; z++) {
                for (double y = 0.5; y < 1000; y++) {
                    inside = false;
                    for (double x = 0; x < 1000; x++) {
                        Point upperFace = new Point(x, y, z);
                        if (faceUnits.contains(upperFace)) {
                            inside  = !inside;
                            faceUnits.remove(upperFace);
                        }
                        if (inside) volume++;
                    }
                }
            }
            return volume;
        }
    }
	
	static class Point{
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
		public String toString()
		{
			return X+" "+Y+" "+Z;
		}
	}
}