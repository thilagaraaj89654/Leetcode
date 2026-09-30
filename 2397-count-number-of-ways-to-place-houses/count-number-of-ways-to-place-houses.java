class Solution {
    public int countHousePlacements(int n) {
        long MOD = 1_000_000_007;
        long empty = 1;
        long house = 1;

        for (int i = 2; i <= n; i++) {
            long newEmpty = (empty + house) % MOD;
            long newHouse = empty;
            empty = newEmpty;
            house = newHouse;
        }

        long totalOneSide = (empty + house) % MOD;
        return (int) ((totalOneSide * totalOneSide) % MOD);
    }
}