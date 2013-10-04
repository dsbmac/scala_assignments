package objsets

object scratch {
	val set1 = new Empty                      //> set1  : objsets.Empty = objsets.Empty@5e0469bc
	val set2 = set1.incl(new Tweet("a", "a body", 20))
                                                  //> set2  : objsets.TweetSet = objsets.NonEmpty@4ee7c6cd
	val set3 = set2.incl(new Tweet("b", "b body", 20))
                                                  //> set3  : objsets.TweetSet = objsets.NonEmpty@4db4b88d
	val c = new Tweet("c", "c body", 7)       //> c  : objsets.Tweet = User: c
                                                  //| Text: c body [7]
	val d = new Tweet("d", "d body", 9)       //> d  : objsets.Tweet = User: d
                                                  //| Text: d body [9]
	val set4c = set3.incl(c)                  //> set4c  : objsets.TweetSet = objsets.NonEmpty@13c058d6
	val set4d = set3.incl(d)                  //> set4d  : objsets.TweetSet = objsets.NonEmpty@390853bb
	val set5 = set4c.incl(d)                  //> set5  : objsets.TweetSet = objsets.NonEmpty@51b1373d

}