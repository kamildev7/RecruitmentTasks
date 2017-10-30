Recruitment Task for a company. 

## Problem 1

A big (encrypted) file was divided into multiple files and sent using different protocols . Every line of the file was randomly put in one of the output files with an information about a line number. 

### Input:

path to a folder with up to 100 plain text files. The total amount of lines from all input files is
from 0 to 214748363 and the maximum line length is 1000 characters.

### Output: 

one ouput file (merge all files in a folder)


## Problem 2 - buy the most profitability plots


All plots have the same area, each of them adjoins its neighbors and their placement resembles a straight line.
Each of the plots has the same selling price. The plots’ placement and numbering:

1  2  3  ...  N-2  N-1  N

The offer also gives the profitability of each of the plots. Some of them are profitable, some are
losing money and the profitability of the rest is 0.

You are going to buy a set of plots which maximize your profit. The profitability of a set of plots is defined as the sum of the profitabilities of each plot in the
set.

Requirements:
- Buy the most profitability plots
- The seller does not want to split his estate excessively (the plots must form a contiguous set).
- When there is more than one correct answer, your program should write the one that contains the smallest number of plots.

### Input
The first line of the input is the number of plots for sale N.
N is a natural number ranging from 1 to
2000000. The second line contains N integers ranging from 1000
to 1000, specifying the profitabilities
of consecutive plots. You can assume that the input is always correct, it conforms to the conditions
above and has at least one plot with a profitability greater than 0.


### Output
Your program should write 3 numbers. The numbers should be separated by a white space. The meaning
of the numbers is, accordingly: number of the first plot in the set; number of the last plot in the set; and
the profitability of the selected set.
