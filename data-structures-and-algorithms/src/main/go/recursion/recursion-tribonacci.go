package recursion
//copy from leetcode
func tribonacci(n int) int {
	nm := make(map[int]int)
	var trib func(n int) int
	trib = func(n int) int {
		switch n {
		case 0:
			return 0
		case 1, 2:
			return 1
		default:
			if v, ok := nm[n]; ok {
				return v
			}
			v := trib(n-1) + trib(n-2) + trib(n-3)
			nm[n] = v
			return v
		}
	}
	return trib(n)
}
