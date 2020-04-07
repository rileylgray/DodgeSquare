package com.tutorial.main;

import java.util.Random;

public class Spawn {

    private Handler handler;
    private HUD hud;
    private int scoreKeep = 0;
    private Random r = new Random();
    private Game game;
    private int timer = 100, xTest, yText, count = 0, xTest2, yText2;
    private GameObject player;

    public Spawn(Handler handler, HUD hud, Game game) {
        this.handler = handler;
        this.game = game;
        this.hud = hud;
    }

    public void tick() {
        scoreKeep++;
        if (scoreKeep % 500 == 0) {
            hud.setLevel(hud.getlevel() + 1);
        }
        if (game.dif == 0)// easy
        {
            if (hud.getlevel() == 2)// 500-1000
            {
                timer--;
                if (scoreKeep % 500 == 0) {
                    timer = 100;

                    count = 0;
                    xTest = r.nextInt(Game.WIDTH - 50);
                    yText = r.nextInt(Game.HEIGHT - 50);

                    handler.addObject(new Warning(xTest, yText, ID.Warning, handler));
                }
                if (timer <= 0) {
                    if (count == 0) {
                        handler.addObject(new BasicEnemy(xTest, yText, ID.BasicEnemy, handler));
                        Random r = new Random();
                        int x = r.nextInt((Game.WIDTH - 0) + 1) + 0;
                        int y = r.nextInt((Game.HEIGHT - 0) + 1) + 0;
                        for (int i = 0; i < handler.object.size(); i++) {
                            if (handler.object.get(i).getId() == ID.Player) {
                                player = handler.object.get(i);
                            }
                        }
                        handler.addObject(new Boss3(player.getX() + 200, player.getY() - 200, ID.Boss, handler));
                        count = 1;
                    }
                }

            } else if (hud.getlevel() == 3)// 1000-1500
            {

                timer--;
                if (scoreKeep % 500 == 0) {
                    timer = 100;

                    count = 0;
                    xTest = r.nextInt(Game.WIDTH - 50);
                    yText = r.nextInt(Game.HEIGHT - 50);
                    handler.addObject(new Warning(xTest, yText, ID.Warning, handler));

                    xTest2 = r.nextInt(Game.WIDTH - 50);
                    yText2 = r.nextInt(Game.HEIGHT - 50);
                    handler.addObject(new Warning(xTest2, yText2, ID.Warning, handler));
                }
                if (timer <= 0) {
                    if (count == 0) {
                        handler.addObject(new BasicEnemy(xTest, yText, ID.BasicEnemy, handler));
                        handler.addObject(new BasicEnemy(xTest2, yText2, ID.BasicEnemy, handler));
                        count = 1;
                    }
                }
            } else if (hud.getlevel() == 4)// 1500-2000
            {
                timer--;
                if (scoreKeep % 500 == 0) {
                    timer = 100;

                    count = 0;
                    xTest = r.nextInt(Game.WIDTH - 50);
                    yText = r.nextInt(Game.HEIGHT - 50);

                    handler.addObject(new Warning(xTest, yText, ID.Warning, handler));
                }
                if (timer <= 0) {
                    if (count == 0) {
                        handler.addObject(new FastEnemy(xTest, yText, ID.FastEnemy, handler));
                        count = 1;
                        Random r = new Random();
                        int x = r.nextInt((Game.WIDTH - 0) + 1) + 0;
                        int y = r.nextInt((Game.HEIGHT - 0) + 1) + 0;
                        for (int i = 0; i < handler.object.size(); i++) {
                            if (handler.object.get(i).getId() == ID.Player) {
                                player = handler.object.get(i);
                            }
                        }
                        handler.addObject(new Boss3(player.getX() + 200, player.getY() - 200, ID.Boss, handler));
                    }
                }
            } else if (hud.getlevel() == 5)// 2000-2500
            {
                if (scoreKeep % 500 == 0) {
                    handler.clearEnemys();
                    handler.addObject(new Boss2((Game.WIDTH / 2 - 64), 0, ID.Boss, handler));
                }
                /*timer--;
				if (scoreKeep % 500 == 0) {
					timer = 100;

					count = 0;
					xTest = r.nextInt(Game.WIDTH - 50);
					yText = r.nextInt(Game.HEIGHT - 50);

					handler.addObject(new Warning(xTest, yText, ID.Warning, handler));
				}
				if (timer <= 0) {
					if (count == 0) {
						handler.addObject(new SmartEnemy(xTest, yText, ID.SmartEnemy, handler));
						count = 1;
					}
				}*/
            } else if (hud.getlevel() == 10)// 2500-3000
            {
                timer--;
                if (scoreKeep % 500 == 0) {
                    timer = 100;

                    count = 0;
                    xTest = r.nextInt(Game.WIDTH - 50);
                    yText = r.nextInt(Game.HEIGHT - 50);

                    handler.addObject(new Warning(xTest, yText, ID.Warning, handler));
                }
                if (timer <= 0) {
                    if (count == 0) {
                        handler.addObject(new FastEnemy(xTest, yText, ID.FastEnemy, handler));
                        count = 1;
                        Random r = new Random();
                        int x = r.nextInt((Game.WIDTH - 0) + 1) + 0;
                        int y = r.nextInt((Game.HEIGHT - 0) + 1) + 0;
                        for (int i = 0; i < handler.object.size(); i++) {
                            if (handler.object.get(i).getId() == ID.Player) {
                                player = handler.object.get(i);
                            }
                        }
                        handler.addObject(new Boss3(player.getX() + 200, player.getY() - 200, ID.Boss, handler));
                    }
                }
            } else if (hud.getlevel() == 11)// 3000-3500, (8)3500-4000, (9) 4000-4500
            {
                timer--;
                if (scoreKeep % 500 == 0) {
                    timer = 100;

                    count = 0;
                    xTest = r.nextInt(Game.WIDTH - 50);
                    yText = r.nextInt(Game.HEIGHT - 50);
                    handler.addObject(new Warning(xTest, yText, ID.Warning, handler));

                    xTest2 = r.nextInt(Game.WIDTH - 50);
                    yText2 = r.nextInt(Game.HEIGHT - 50);
                    handler.addObject(new Warning(xTest2, yText2, ID.Warning, handler));
                }
                if (timer <= 0) {
                    if (count == 0) {
                        handler.addObject(new FastEnemy(xTest, yText, ID.FastEnemy, handler));
                        handler.addObject(new BasicEnemy(xTest2, yText2, ID.BasicEnemy, handler));
                        count = 1;
                    }
                }

            } else if (hud.getlevel() == 12)// 4500-6500
            {
                if (scoreKeep % 500 == 0) {
                    handler.clearEnemys();
                    handler.addObject(new Boss((Game.WIDTH / 2 - 48), -120, ID.Boss, handler));
                }

            } else if (hud.getlevel() == 17) {
                timer--;
                if (scoreKeep % 500 == 0) {
                    timer = 100;

                    count = 0;
                    xTest = r.nextInt(Game.WIDTH - 50);
                    yText = r.nextInt(Game.HEIGHT - 50);
                    handler.addObject(new Warning(xTest, yText, ID.Warning, handler));

                    xTest2 = r.nextInt(Game.WIDTH - 50);
                    yText2 = r.nextInt(Game.HEIGHT - 50);
                    handler.addObject(new Warning(xTest2, yText2, ID.Warning, handler));
                }
                if (timer <= 0) {
                    if (count == 0) {
                        handler.addObject(new SmartEnemy(xTest, yText, ID.SmartEnemy, handler));
                        handler.addObject(new SmartEnemy(xTest2, yText2, ID.SmartEnemy, handler));
                        count = 1;
                    }
                }
            } else if (hud.getlevel() >= 18 && hud.getlevel() <= 20) {
                timer--;
                if (scoreKeep % 500 == 0) {
                    timer = 100;

                    count = 0;
                    xTest = r.nextInt(Game.WIDTH - 50);
                    yText = r.nextInt(Game.HEIGHT - 50);
                    handler.addObject(new Warning(xTest, yText, ID.Warning, handler));

                    xTest2 = r.nextInt(Game.WIDTH - 50);
                    yText2 = r.nextInt(Game.HEIGHT - 50);
                    handler.addObject(new Warning(xTest2, yText2, ID.Warning, handler));
                }
                if (timer <= 0) {
                    if (count == 0) {
                        handler.addObject(new FastEnemy(xTest, yText, ID.FastEnemy, handler));
                        handler.addObject(new BasicEnemy(xTest2, yText2, ID.BasicEnemy, handler));
                        count = 1;
                    }
                }
            } else if (hud.getlevel() >= 20) {
                timer--;

                if (scoreKeep % 500 == 0) {
                    timer = 100;

                    count = 0;
                    xTest = r.nextInt(Game.WIDTH - 50);
                    yText = r.nextInt(Game.HEIGHT - 50);

                    handler.addObject(new Warning(xTest, yText, ID.Warning, handler));
                }

                if (timer <= 0) {
                    if (count == 0) {
                        handler.addObject(new FastEnemy(xTest, yText, ID.FastEnemy, handler));
                        count = 1;
                    }

                }
            }
        } else if (game.dif == 1)// Hard
        {
            if (hud.getlevel() == 2)// 500-1000
            {
                timer--;
                if (scoreKeep % 500 == 0) {
                    timer = 100;

                    count = 0;
                    xTest = r.nextInt(Game.WIDTH - 50);
                    yText = r.nextInt(Game.HEIGHT - 50);

                    handler.addObject(new Warning(xTest, yText, ID.Warning, handler));
                }
                if (timer <= 0) {
                    if (count == 0) {
                        handler.addObject(new HardEnemy(xTest, yText, ID.BasicEnemy, handler));
                        count = 1;
                    }
                }

            } else if (hud.getlevel() == 3)// 1000-1500
            {

                timer--;
                if (scoreKeep % 500 == 0) {
                    timer = 100;

                    count = 0;
                    xTest = r.nextInt(Game.WIDTH - 50);
                    yText = r.nextInt(Game.HEIGHT - 50);
                    handler.addObject(new Warning(xTest, yText, ID.Warning, handler));

                    xTest2 = r.nextInt(Game.WIDTH - 50);
                    yText2 = r.nextInt(Game.HEIGHT - 50);
                    handler.addObject(new Warning(xTest2, yText2, ID.Warning, handler));
                }
                if (timer <= 0) {
                    if (count == 0) {
                        handler.addObject(new HardEnemy(xTest, yText, ID.BasicEnemy, handler));
                        handler.addObject(new HardEnemy(xTest, yText, ID.BasicEnemy, handler));
                        count = 1;
                    }
                }
            } else if (hud.getlevel() == 4)// 1500-2000
            {
                timer--;
                if (scoreKeep % 500 == 0) {
                    timer = 100;

                    count = 0;
                    xTest = r.nextInt(Game.WIDTH - 50);
                    yText = r.nextInt(Game.HEIGHT - 50);

                    handler.addObject(new Warning(xTest, yText, ID.Warning, handler));
                }
                if (timer <= 0) {
                    if (count == 0) {
                        handler.addObject(new FastEnemy(xTest, yText, ID.FastEnemy, handler));
                        count = 1;
                    }
                }
            } else if (hud.getlevel() == 5)// 2000-2500
            {
                timer--;
                if (scoreKeep % 500 == 0) {
                    timer = 100;

                    count = 0;
                    xTest = r.nextInt(Game.WIDTH - 50);
                    yText = r.nextInt(Game.HEIGHT - 50);

                    handler.addObject(new Warning(xTest, yText, ID.Warning, handler));
                }
                if (timer <= 0) {
                    if (count == 0) {
                        handler.addObject(new SmartEnemy(xTest, yText, ID.SmartEnemy, handler));
                        count = 1;
                    }
                }
            } else if (hud.getlevel() == 6)// 2500-3000
            {
                timer--;
                if (scoreKeep % 500 == 0) {
                    timer = 100;

                    count = 0;
                    xTest = r.nextInt(Game.WIDTH - 50);
                    yText = r.nextInt(Game.HEIGHT - 50);

                    handler.addObject(new Warning(xTest, yText, ID.Warning, handler));
                }
                if (timer <= 0) {
                    if (count == 0) {
                        handler.addObject(new FastEnemy(xTest, yText, ID.FastEnemy, handler));
                        count = 1;
                    }
                }
            } else if (hud.getlevel() == 7)// 3000-3500, (8)3500-4000, (9) 4000-4500
            {
                timer--;
                if (scoreKeep % 500 == 0) {
                    timer = 100;

                    count = 0;
                    xTest = r.nextInt(Game.WIDTH - 50);
                    yText = r.nextInt(Game.HEIGHT - 50);
                    handler.addObject(new Warning(xTest, yText, ID.Warning, handler));

                    xTest2 = r.nextInt(Game.WIDTH - 50);
                    yText2 = r.nextInt(Game.HEIGHT - 50);
                    handler.addObject(new Warning(xTest2, yText2, ID.Warning, handler));
                }
                if (timer <= 0) {
                    if (count == 0) {
                        handler.addObject(new FastEnemy(xTest, yText, ID.FastEnemy, handler));
                        handler.addObject(new HardEnemy(xTest, yText, ID.BasicEnemy, handler));
                        count = 1;
                    }
                }

            } else if (hud.getlevel() == 10)// 4500-6500
            {
                if (scoreKeep % 500 == 0) {
                    handler.clearEnemys();
                    handler.addObject(new Boss((Game.WIDTH / 2 - 48), -120, ID.Boss, handler));
                }

            } else if (hud.getlevel() == 15) {
                timer--;
                if (scoreKeep % 500 == 0) {
                    timer = 100;

                    count = 0;
                    xTest = r.nextInt(Game.WIDTH - 50);
                    yText = r.nextInt(Game.HEIGHT - 50);
                    handler.addObject(new Warning(xTest, yText, ID.Warning, handler));

                    xTest2 = r.nextInt(Game.WIDTH - 50);
                    yText2 = r.nextInt(Game.HEIGHT - 50);
                    handler.addObject(new Warning(xTest2, yText2, ID.Warning, handler));
                }
                if (timer <= 0) {
                    if (count == 0) {
                        handler.addObject(new SmartEnemy(xTest, yText, ID.SmartEnemy, handler));
                        handler.addObject(new SmartEnemy(xTest2, yText2, ID.SmartEnemy, handler));
                        count = 1;
                    }
                }
            } else if (hud.getlevel() >= 14 && hud.getlevel() <= 20) {
                timer--;
                if (scoreKeep % 500 == 0) {
                    timer = 100;

                    count = 0;
                    xTest = r.nextInt(Game.WIDTH - 50);
                    yText = r.nextInt(Game.HEIGHT - 50);
                    handler.addObject(new Warning(xTest, yText, ID.Warning, handler));

                    xTest2 = r.nextInt(Game.WIDTH - 50);
                    yText2 = r.nextInt(Game.HEIGHT - 50);
                    handler.addObject(new Warning(xTest2, yText2, ID.Warning, handler));
                }
                if (timer <= 0) {
                    if (count == 0) {
                        handler.addObject(new FastEnemy(xTest, yText, ID.FastEnemy, handler));
                        handler.addObject(new HardEnemy(xTest, yText, ID.BasicEnemy, handler));
                        count = 1;
                    }
                }
            } else if (hud.getlevel() >= 20) {
                timer--;

                if (scoreKeep % 500 == 0) {
                    timer = 100;

                    count = 0;
                    xTest = r.nextInt(Game.WIDTH - 50);
                    yText = r.nextInt(Game.HEIGHT - 50);

                    handler.addObject(new Warning(xTest, yText, ID.Warning, handler));
                }

                if (timer <= 0) {
                    if (count == 0) {
                        handler.addObject(new FastEnemy(xTest, yText, ID.FastEnemy, handler));
                        count = 1;
                    }

                }
            }
        }
    }
}
