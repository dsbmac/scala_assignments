package objsets

object scratch {
	val set1 = new Empty                      //> set1  : objsets.Empty = objsets.Empty@4377c8ac
	val set2 = set1.incl(new Tweet("a", "a body", 20))
                                                  //> set2  : objsets.TweetSet = objsets.NonEmpty@578cbd65
	val set3 = set2.incl(new Tweet("b", "b body", 20))
                                                  //> set3  : objsets.TweetSet = objsets.NonEmpty@3b42c565
	val c = new Tweet("c", "c body", 7)       //> c  : objsets.Tweet = User: c
                                                  //| Text: c body [7]
	val d = new Tweet("d", "d body", 9)       //> d  : objsets.Tweet = User: d
                                                  //| Text: d body [9]
	val set4c = set3.incl(c)                  //> set4c  : objsets.TweetSet = objsets.NonEmpty@1cad8848
	val set4d = set3.incl(d)                  //> set4d  : objsets.TweetSet = objsets.NonEmpty@44ce3dad
	val set5 = set4c.incl(d)                  //> set5  : objsets.TweetSet = objsets.NonEmpty@40334c25
	
	def asSet(tweets: TweetSet): Set[Tweet] = {
    var res = Set[Tweet]()
    tweets.foreach(res += _)
    res
  }                                               //> asSet: (tweets: objsets.TweetSet)Set[objsets.Tweet]
  
  def size(set: TweetSet): Int = asSet(set).size  //> size: (set: objsets.TweetSet)Int
  
	
}