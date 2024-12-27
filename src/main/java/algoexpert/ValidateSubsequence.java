package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidateSubsequence {

/*

https://www.algoexpert.io/questions/Validate%20Subsequence

    <div class="html">
<p>
  Given two non-empty arrays of integers, write a function that determines
  whether the second array is a subsequence of the first one.
</p>
<p><pre>true
</pre>
  A subsequence of an array is a set of numbers that aren't necessarily adjacent
  in the array but that are in the same order as they appear in the array. For
  instance, the numbers <span>[1, 3, 4]</span> form a subsequence of the array
  <span>[1, 2, 3, 4]</span>, and so do the numbers <span>[2, 4]</span>. Note
  that a single number in an array and the array itself are both valid
  subsequences of the array.
</p>
<h3>Sample Input</h3>
<pre><span class="CodeEditor-promptParameter">array</span> = [5, 1, 22, 25, 6, -1, 8, 10]
<span class="CodeEditor-promptParameter">sequence</span> = [1, 6, -1, 10]
</pre>
<h3>Sample Output</h3>

</div>

    /
 */

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> sequence = Arrays.asList(1, 6, -1, 10);
        boolean isValidSubsequence = isValidSubsequence(array, sequence);
        System.out.println(isValidSubsequence);
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {

        int sequenceIndex=0;
        int arrayIndex=0;

        while(arrayIndex < array.size()){

            if(sequence.get(sequenceIndex) == array.get(arrayIndex)){
                sequenceIndex++;
            }

            arrayIndex++;
        }

        return sequenceIndex == sequence.size();

    }
}
