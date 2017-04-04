package life.grass.grassplayer.achievement;

/* package */ interface Achievement {

    String getName();

    int getMaxValue();

    boolean isOpened(int value);
}
