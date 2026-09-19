class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int nearestX = Math.max(x1, Math.min(xCenter, x2));
        int nearestY = Math.max(y1, Math.min(yCenter, y2));
        
        int distX = xCenter - nearestX;
        int distY = yCenter - nearestY;
        
        return (distX * distX + distY * distY) <= radius * radius;
    }
}