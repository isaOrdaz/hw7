# Project 1 (Zip) Write-Up #
--------

#### How Was Your Partnership? ####
-   Did both partners do an equal amount of work?  If not, why not?
    What happened?<pre>
**TODO**: Answer this question
</pre><br>
    I believe we both did the same amount of work. Jacob maybe did a little more 
    because of the way we decided to split up the checkpoints and classes. Some 
    that Jacob had ended up being more work/more difficult than mine. 
    
-----
#### Project Enjoyment ####
-   What was your favorite part of the project?  What was your least
    favorite part of the project?<pre>
**TODO**: Answer this question
</pre><br>
    My favorite part of the porject was being able to use Git to collaborate
    with my partner. In someways however it was also my least faovrite part
    of the project because since I am still new to Git, merge confilicts 
    are something that I am stil not familiar with. Not having that familiarity
    with the merge confits it was sometimes 

-   Did you enjoy the project?<pre>
**TODO**: Answer this question
</pre><br>
    Desipte the stress of having a somewhat short timeline I think I did enjoy
    this project. I enojyed being able use Git and share the project that way. 
    
-----

#### WorkLists, Tries, and Zip ####
-   The ADT for a WorkList explicitly forbids access to the middle elements.  However, the FixedSizeFIFOWorkList has a peek(i) method
    which allows you to do exactly that.  Why is this an acceptable addition to the WorkList ADT in this particular case but not in general?<pre>
**TODO**: Answer this question
</pre><br>
    When the size is fized we don't need to go through every element to get the size. That
    way the time complexity is O(1) rather than O(n) saving time when it is a fixed size. 

-   As we've described it, a `TrieMap` seems like a general-purpose replacement for `HashMap` or `TreeMap`.  Why might we still want to use one
    of these other data structures instead?<pre>
**TODO**: Answer this question
</pre><br>
    We would want to use the other data structures when we want to use include int and dictionary
    
-   One of the applications of Tries is in solving Word Searches.  A "word search" is an n x m rectangle of letters.  The goal is to find all
    of the possible words (horizontal, vertical, diagonal, etc.).  In Boggle, a similar game, any consecutive chain of letters (even repetitions)
    are allowed.  Explain (in very high-level psuedo-code) how you might solve this problem with a TrieSet or a TrieMap.  Make sure to detail
    how a similar solution that uses a HashSet/HashMap instead would be different and why using a Trie might make the solution better.<pre>
**TODO**: Answer this question
</pre><br>
    To solve this with a TrieMap you would move through each row and col in the puzzle, using
    recursive backtracking to add all possible words to the Map then remove the last one. 

