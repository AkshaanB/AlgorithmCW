Note: The project is built using IntelliJ IDEA 
      Java SDK: 1.8
      Stopwatch class is a library used for time estimation.
      *All the tasks have been tried out

Below are some guidelines for my project.

There are 2 packages in the Project (Code_1 and Code_2). 

1) The implementation in the Code_1 package is where the user can select an option whether to find the maximum flow, delete node, modify capacity and exit the program.
   Object from Stopwatch class is created at the beginning of the main method. 
   So, the time complexity for the maximum flow will also have the time which went for the user to enter the options.

2) The implementation in the Code_2 package is done for measuring the exact running time of the algorithm. 
   It’ll first display the maximum flow for the existing graph (data read from the dataset) and it’s running time.
   Then it displays the options whether to delete a node, modify capacity along with finding the maximum flow.

Either Code_1 or Code_2 package can be run in the viva. But, most preferred to run in the viva is Code_2 package.
Because, The implementation in the Code_2 package is done for measuring the exact running time of the algorithm.

Below is the only special characteristic that should be considered when running my project.

> Dataset insertion
1) File path is assigned to filePath variable. The code String filePath = "D:\\My Work\\Syllabus\\Algorithms\\CW\\Implmentation\\"; depicts it.
   So, when the zip file is extract to some location the location should be altered in the above code line. 
   Dataset files are named as Data6x6.txt, Data12x12.txt, Data24x24.txt, Data48x48.txt respectively.
   The thing that should be done to insert the dataset is type the file name at the below described manner.
   Note: Please make sure type the name of file as shown below and make sure not to keep space between starting apostrophe and letter D.

   For ease of finding the below code, I have set up a comment as //**, below that comment resides the following code.

   graph = matrix(filePath+"Data6x6.txt");
   or
   graph = matrix(filePath+"Data12x12.txt");
   or
   graph = matrix(filePath+"Data24x24.txt");
   or
   graph = matrix(filePath+"Data48x48.txt");

2) Insertion of Source and Sink
   In my project Source and Sink are read from the file which is named as GeneralData.txt.
   Note: The first line of the file is the Source while the second line is the Sink.
   Please make sure not to change the source and sink as thought.
   Because this data will be added to an ArrayList an the first element in that ArrayList is assumed as the Source while second element is assumed as the Sink.
   
   data = new Scanner(new File(filePath+"GeneralData.txt"));
   
   The above line of code resides right below the code line in section 1 of this document.
   
After deleting and changing the capacity of a certain node it'll prompt whether to save the data or not. 
Details are given for what option the user should enter through the prompt

The details are: Do you want to save the file? (enter y or yes or 1 OR vice versa)
If the user needs to save the file type y, yes or 1. Otherwise n, no or 0

If the user entered that s(he) needs to save the graph, the graph will be saved in Save_Data.txt file.

I assume that all the things that I need to specify regarding the project are clearly explained.


<--Dhanasekara Mudiyanselage Akshaan Dileesha Bandara -->
<-- UOW_ID / IIT_ID = w1743055 / 2018597 -->
