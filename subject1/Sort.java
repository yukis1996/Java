public class Sort {
	public static void main (String[] args) {
		int[] nums = new int[args.length];
		for (int i = 0; i < args.length; i++) {
		nums[i] = Integer.parseInt(args[i]);
		}
		for (int i = 0; i < args.length -1; i++) {
			for (int j = 0; j < args.length -i -1; j++) {
				if (nums[j] > nums[j + 1]) {
					int number = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = number;
				}
			}
		}
		for (int i = 0; i < args.length; i++) {
			System.out.println(nums[i]);
		}		
	}
}
