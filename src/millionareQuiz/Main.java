package millionareQuiz;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		/********************************************/
		int[] easyPrize = { 100, 500, 1000, 8000, 16000, 32000, 125000, 500000, 1000000 };
		int[] hardPrize = { 100, 200, 300, 500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 125000, 250000, 500000,
				1000000 };
		int prizeMoney = 0;
		int j = 0;
		int k = 0;
		int round = 0;
		int qNo = 0;
		int remainder = 0;

		int incorrectAns = 0;
		boolean walkAway = false;
		boolean doneQues;
		boolean fiftyfiftyUsed = false;
		int choice;
		String selectedOptionPAF = "";
		String selectedOptionATA = "";
		String correctAnswer = "";

		// Define Questions, Options and Answers

		String[] questions = { /* 1 */ "What is the capital of France?",
				/* 2 */ "What is the largest country in the world?",
				/* 3 */ "What is the highest mountain in the world?",
				/* 4 */ "What is the smallest country in the world?",
				/* 5 */ "Who directed the movie \"The Shawshank Redemption\"?",
				/* 6 */ "What is the capital city of Thailand?",
				/* 7 */ "What is the smallest planet in the solar system?",
				/* 8 */ "Which country gifted the Statue of Liberty to the United States?",
				/* 9 */ "What is the chemical symbol for gold?",
				/* 10 */ "Who wrote the novel \"To Kill a Mockingbird\"?",
				/* 11 */ "Which is the largest ocean in the world?", /* 12 */ "Who invented the telephone?",
				/* 13 */ "What is the chemical symbol for oxygen?",
				/* 14 */ "Which planet in our solar system is known for having a large ring system?",
				/* 15 */ "Who painted the famous artwork \"The Starry Night\"?",
				/* 16 */ "What is the tallest mountain in North America?",
				/* 17 */ "What is the capital city of Australia?",
				/* 18 */ "Who is the author of the Harry Potter book series?",
				/* 19 */ "What is the largest country by area in the world?" };

		String[][] options = { /* 1 */ { "A. London", "B. Berlin", "C. Paris", "D. Madrid" },
				/* 2 */{ "A. Russia", "B. Canada", "C. China", "D. USA" },
				/* 3 */{ "A. Mount Everest", "B. K2", "C. Kangchenjunga", "D. Lhotse" },
				/* 4 */{ "A. Monaco", "B. Vatican City", "C. San Marino", "D. Andorra" },
				/* 5 */{ "A. Martin Scorsese", "B. Frank Darabont", "C. Quentin Tarantino", "D. Steven Spielberg" },
				/* 6 */{ "A. Bangkok", "B. Hanoi", "C. Manila", "D. Jakarta" },
				/* 7 */{ "A. Venus", "B. Mercury", "C. Mars", "D. Earth" },
				/* 8 */{ "A. France", "B. Italy", "C. Spain", "D. Portugal" },
				/* 9 */{ "A. Ag", "B. Cu", "C. Au", "D. Fe" },
				/* 10 */{ "A. Ernest Hemingway", "B. J.D. Salinger", "C. Harper Lee", "D. F. Scott Fitzgerald" },
				/* 11 */{ "A. Indian Ocean", "B. Atlantic Ocean", "C. Pacific Ocean", "D. Arctic Ocean" },
				/* 12 */{ "A. Thomas Edison", "B. Alexander Graham Bell", "C. Benjamin Franklin", "D. Isaac Newton" },
				/* 13 */{ "A. H", "B. O", "C. C", "D. N" },
				/* 14 */{ "A. Saturn", "B. Jupiter", "C. Uranus", "D. Neptune" },
				/* 15 */{ "A. Vincent van Gogh", "B. Pablo Picasso", "C. Claude Monet", "D. Salvador Dali" },
				/* 16 */{ "A. Mount St. Helens", "B. Mount McKinley (Denali)", "C. Mount Rainier", "D. Mount Shasta" },
				/* 17 */{ "A. Sydney", "B. Melbourne", "C. Perth", "D. Canberra" },
				/* 18 */{ "A. J.K. Rowling", "B. Stephenie Meyer", "C. Suzanne Collins", "D. Veronica Roth" },
				/* 19 */{ "A. Russia", "B. China", "C. Canada", "D. United States" } };

		String[] answers = { /* 1 */ "C", /* 2 */ "A", /* 3 */ "A", /* 4 */ "B", /* 5 */ "B", /* 6 */ "A", /* 7 */ "B",
				/* 8 */ "A", /* 9 */ "C", /* 10 */ "C", /* 11 */"C", /* 12 */ "B", /* 13 */ "B", /* 14 */ "A",
				/* 15 */"B", /* 16 */ "B", /* 17 */ "D", /* 18 */"A", /* 19 */"A" };

		// Shuffle the indices to randomize the questions
		List<Integer> indices = new ArrayList<Integer>();
		for (int i = 0; i < questions.length; i++) {
			indices.add(i);
		}
		Collections.shuffle(indices);

		List<Integer> usedIndices = new ArrayList<Integer>();
		List<String> usedLifeline = new ArrayList<String>();
		List<String> usedLL = new ArrayList<String>();
		List<Character> nullOptions = new ArrayList<>();

		List<String> lifelines = new ArrayList<String>();
		lifelines.add("50 - 50");
		lifelines.add("Phone A Friend");
		lifelines.add("Ask The Audience");

		List<String> lifelineOption = new ArrayList<String>();
		lifelineOption.add("F");
		lifelineOption.add("P");
		lifelineOption.add("E");

		List<String> answerChoice = new ArrayList<String>();
		answerChoice.add("A");
		answerChoice.add("B");
		answerChoice.add("C");
		answerChoice.add("D");
		/**********************************************/

		// Game

		while (true) {
			System.out.println("\nWelcome to the Game!");
			System.out.println("\nPlease select an option:");
			System.out.println("\n1. Start the game");
			System.out.println("2. View the rules of the game");
			System.out.println("3. Exit the game");

			try {
				choice = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid input. Please try again.");
				input.nextLine();
				continue;
			}

			switch (choice) {
			case 1: // Start Game

				System.out.println("\nWELCOME TO WHO WANTS TO BE A MILLIONARE in 9 - 15 Questions!!");

				try {
					Thread.sleep(2000); // sleep for 1 second (1000 milliseconds)
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println("\nThis is your host Hemyush Deoli!!\n");

				try {
					Thread.sleep(2000); // sleep for 1 second (1000 milliseconds)
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.print("Before starting the game, Enter your name: ");
				input.nextLine(); // add this line to consume the newline character
				String name = input.nextLine();

				System.out.print("\nChoose a difficulty level \n(E) Easy Mode \n(H) Hard Mode \n");
				System.out.println("\nEnter Difficulty Mode: ");

				String difficulty = input.nextLine().toLowerCase();

				switch (difficulty) {
				case "e": // Easy Difficulty

					System.out.println("\nWelcome " + name + " to \"Who Wants to be a Millionare\"!\n");

					try {
						Thread.sleep(3000); // sleep for 1 second (1000 milliseconds)
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println(
							"\nLet us begin your journey towards becoming a millionare!! (In easy mode because someone is too scared to tackle more questions) \n");

					try {
						Thread.sleep(3000); // sleep for 1 second (1000 milliseconds)
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println("\nHere is the recap of the rules:");

					try {
						Thread.sleep(3000); // sleep for 1 second (1000 milliseconds)
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println("\n- There will be 3 rounds of questions with 3 questions each.\n");

					try {
						Thread.sleep(3000); // sleep for 1 second (1000 milliseconds)
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println(
							"\n- After answering correctly 3 times, you would have the oppurtunity to either \' Walk Away \' with the prize money you have won till that point, or keep going.\n");

					try {
						Thread.sleep(3000); // sleep for 1 second (1000 milliseconds)
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println("\n- For each question you will have lifelines available:\n");

					try {
						Thread.sleep(3000); // sleep for 1 second (1000 milliseconds)
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println("\n '50-50' - Removes two incorrect options\n");

					try {
						Thread.sleep(3000); // sleep for 1 second (1000 milliseconds)
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println(
							"\n 'Phone A Friend' - Calls up a friend of your choosimg, who will have 75% chance of giving you the correct answer, but also have a '1/1024 th' chance to not answer at all. \n");

					try {
						Thread.sleep(3000); // sleep for 1 second (1000 milliseconds)
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println(
							"\n 'Audience Poll' - Asks the audience to choose an answer for you, with a 60% chance of the answer chosen being correct.\n");

					try {
						Thread.sleep(3000); // sleep for 1 second (1000 milliseconds)
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println("\n- That's it for the Rules!\n");

					try {
						Thread.sleep(3000); // sleep for 1 second (1000 milliseconds)
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					while (round < 3 && !walkAway) {

						System.out.println("We begin with Round " + (round + 1) + "!!\n");

						try {
							Thread.sleep(2000); // sleep for 1 second (1000 milliseconds)
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

						for (int i = 0; i < 3; i++) { // To have 3 questions for each round

							doneQues = false; // To check whether a question has been completed
							qNo++; // To display Question Number

							System.out.println("Your current earnings are $" + prizeMoney);

							try {
								Thread.sleep(2000); // sleep for 1 second (1000 milliseconds)
							} catch (InterruptedException e) {
								e.printStackTrace();
							}

							System.out.println("\nQuestion " + (qNo) + " is for $" + (easyPrize[qNo - 1]) + "\n\n"); // To
																														// make
																														// the
																														// index
																														// of
																														// easyPrize
																														// '0'
																														// at
																														// first

							if (easyPrize[qNo - 1] == 1000000) // Special Message for million dollar question
							{
								try {
									Thread.sleep(2000); // sleep for 1 second (1000 milliseconds)
								} catch (InterruptedException e) {
									e.printStackTrace();
								}

								System.out.println("\nThis is the final question!!!\nGood Luck!!!");
							}

							try {
								Thread.sleep(2000); // sleep for 1 second (1000 milliseconds)
							} catch (InterruptedException e) {
								e.printStackTrace();
							}

							// To get question

							int index = indices.get(j); // Indices is a list, with a shuffled question order
							while (usedIndices.contains(index)) { // If question has been used before, get a new
																	// question
								index = indices.get(j);
							}
							usedIndices.add(index); // Mark the question as used

							j++; // to get the next question

							while (!doneQues) // Till the answer choice is given
							{
								// To get options
								System.out.println("Question " + (qNo) + ": " + questions[index] + "\n"); // To print
																											// question,
																											// based on
																											// Indices

								for (String option : options[index]) { // To print options by iterating through the
																		// 'options' Array

									if (option != null) { // This is used to check for 50-50

										try {
											Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
										} catch (InterruptedException e) {
											e.printStackTrace();
										}

										System.out.println(option);
									}
								}

								try {
									Thread.sleep(2000); // sleep for 1 second (1000 milliseconds)
								} catch (InterruptedException e) {
									e.printStackTrace();
								}

								System.out.print("\nEnter ");

								for (int s = 0; s < 4; s++) // To print from A to D, but changes when 50-50 is applied
								{
									if (!nullOptions.contains(answerChoice.get(s).charAt(0))) {
										System.out.print("'" + answerChoice.get(s) + "' ");
									}

								}

								System.out.print("to choose an option\n\n");

								try {
									Thread.sleep(2000); // sleep for 1 second (1000 milliseconds)
								} catch (InterruptedException e) {
									e.printStackTrace();
								}

								if (!lifelines.isEmpty()) { // This block of code is to print available lifelines
									System.out.println("Remaining lifelines: " + lifelines + "\n");

									try {
										Thread.sleep(2000); // sleep for 1 second (1000 milliseconds)
									} catch (InterruptedException e) {
										e.printStackTrace();
									}

									System.out.println("To choose a lifeline press:\n");

									for (int l = 0; l < lifelines.size(); l++) {

										try {
											Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
										} catch (InterruptedException e) {
											e.printStackTrace();
										}

										System.out.print("Press \"" + (lifelineOption.get(l)) + "\" for "
												+ (lifelines.get(l)) + "\n"); // TO print F, P and E based on available
																				// lifelines

									}
								}

								else {
									System.out.println("Remaining lifelines: YOU HAVE NO LIFELINES LEFT (GOOD LUCK)\n");
								}

								try {
									Thread.sleep(2000); // sleep for 1 second (1000 milliseconds)
								} catch (InterruptedException e) {
									e.printStackTrace();
								}

								System.out.println("\nEnter Your Choice: "); // To enter the available options -
																				// lifeline or answer

								String answerOption = input.nextLine().toUpperCase(); // They are uppercase for easier
																						// comparison
								char charAnswerOption = answerOption.charAt(0); // To make the option a char type for
																				// comparison

								if (answerChoice.contains(answerOption) && !nullOptions.contains(charAnswerOption)) { // To
																														// check
																														// for
																														// available
																														// options,
																														// even
																														// in
																														// case
																														// for
																														// 50-50
																														// remove.
																														// This
																														// code
																														// is
																														// for
																														// eligible
																														// option

									System.out.print("\nIs the option '");

									for (int i1 = 0; i1 < 4; i1++) // This will iterate through options, to find the one
																	// matching the initial alphabet as the answerChoice
									{
										if (options[index][i1] == null) {
											continue;
										}

										else if (options[index][i1].charAt(0) == charAnswerOption) {
											System.out.print(options[index][i1]);
										}
									}

									System.out.print("' your final answer? \nY for YES \nN (or any key) for NO\n");

									String answerConfirm = input.nextLine(); // For Yes Or No

									if (answerConfirm.equalsIgnoreCase("y")) { // To check if the answer is correct or
																				// not

										for (int l = 0; l < 3; l++) {

											System.out.println(".");

											try {
												Thread.sleep(800); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}
										}

										if (answerOption.equals(answers[index])) {// If answer is correct
											doneQues = true;
											fiftyfiftyUsed = false; // So that it resets and is not used for future Ask
																	// the Audience because the ATA logic requires a
																	// check for 50-50

											System.out.println("Correct Answer!!");
											prizeMoney = easyPrize[qNo - 1];

											if (prizeMoney != 1000000) {// To show prize money till its not a million
												System.out.println("You have won $" + prizeMoney);

												try {
													Thread.sleep(800); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println("\nOnto the Next Question!\n");

												try {
													Thread.sleep(800); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

											}
											nullOptions.clear();// For future checks of other question. Just so that the
																// 50-50 removed questions are available

											try {
												Thread.sleep(800); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

										}

										else {// This loop is for Incorrect Answer
											System.out.println("\nIncorrect Answer!!");

											try {
												Thread.sleep(800); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											for (int a3 = 0; a3 < 4; a3++)// To display the correct answer
											{
												if (options[index][a3].charAt(0) == answers[index].charAt(0)) {
													correctAnswer = options[index][a3];
												}
											}
											System.out.println("\nThe Correct Answer is: " + (correctAnswer));

											try {
												Thread.sleep(800); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println(
													"\nSorry You Have Lost the Game and all your Prize Money  :(");

											try {
												Thread.sleep(800); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											incorrectAns = 1; // To get out after answering Incorrectly
										}

										if (incorrectAns == 1) {
											doneQues = true;
											walkAway = true;

										}

									}

									else {// This is the No option to confirm your answer Choice. If you press A but are
											// not sure.
										System.out.println("\nOkay Re - Enter Your choice\n");
										continue;
									}
								}

								// Lifeline Use!

								else if (lifelineOption.contains(answerOption)) { // If answer Choice is one of the
																					// lifelines.

									System.out.println("\nDo you wish to use your \""
											+ lifelines.get(lifelineOption.indexOf(answerOption))
											+ "\" lifeline?\nY for YES \nN (or any key) for NO"); // To confirm uiuf you
																									// want to use
																									// lifeline

									String lifelineConfirm = input.nextLine();

									if (lifelineConfirm.equalsIgnoreCase("y"))

									{

										usedLifeline.add(answerOption);// To not be able to use lifeline in future
										int indexLifeline = lifelineOption.indexOf(answerOption);
										usedLL.add(lifelines.get(indexLifeline));// To not be able to use lifeline
																					// character

										System.out.println("\nYou decided to use up your \""
												+ lifelines.get(indexLifeline) + "\" lifeline!");

										try {
											Thread.sleep(2000); // sleep for 1 second (1000 milliseconds)
										} catch (InterruptedException e) {
											e.printStackTrace();
										}

										lifelines.remove(indexLifeline);
										lifelineOption.remove(indexLifeline);

										switch (answerOption) {// When answer Option is one of the Lifelines

										case "F":

											fiftyfiftyUsed = true;

											System.out.println(
													"\nWe will now remove two of the incorrect options from the screen.");

											try {
												Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println(
													"\nHere is the question again with the two of the incorrect options removed!!\n");

											try {
												Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											String[][] incorrectAnswers = new String[1][3];

											for (int m = 0; m < 4; m++) {
												if (!options[index][m].startsWith(answers[index])) {// If the options do
																									// not start with
																									// the character of
																									// correct answer
													incorrectAnswers[0][k] = options[index][m];
													k++;
												}
											}

											Random random = new Random();
											int randomNumber = random.nextInt(3);

											String[][] newOptions = new String[1][2];

											String correctResult = new String();

											for (String option : options[index]) {
												if (option.startsWith(answers[index])) {
													correctResult = option;
													break;
												}
											}

											newOptions[0][0] = correctResult;
											newOptions[0][1] = incorrectAnswers[0][randomNumber];
											Arrays.sort(newOptions[0]);// To sort alphabetically

											for (int s = 0; s < 3; s++) {// To add the removed options to nullOptions,
																			// so that they can't be used.
												if (s != randomNumber) {
													nullOptions.add(incorrectAnswers[0][s].charAt(0));
												}
											}

											for (int a = 0; a < 1; a++) {
												for (int m = 0; m < 4; m++) {
													if (m < 2) {
														options[index][m] = newOptions[a][m];
													} else {
														options[index][m] = null;// The options after 50-50 will be
																					// checked if they are null and
																					// won't displayed
													}
												}
											}

											break;

										case "P":

											System.out.println(
													"\nALRIGHT! Since you have decided to use your 'Phone A Friend' Lifeline, please tell us the name of your friend:");

											String friendName = input.nextLine();

											System.out.println(
													"\nAlright, Mr. Computer! Please try and contact our contestant, "
															+ name + "'s friend, " + friendName + "! \n");

											Random rand = new Random();
											int callDuration1 = rand.nextInt(3) + 4;

											for (int m = 0; m < callDuration1; m++) {
												for (int n = 0; n < 3; n++) {
													try {
														Thread.sleep(700); // sleep for 1 second (1000 milliseconds)
													} catch (InterruptedException e) {
														e.printStackTrace();
													}
													System.out.print(". ");
												}
												System.out.println();

											}

											System.out.println("*picks up reciever..*\n");

											try {
												Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println(friendName + ": Hello!\n");

											try {
												Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println("HD: Am I speaking with " + friendName + "?\n");

											try {
												Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println(friendName + ": Yes, who's speaking?\n");

											try {
												Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println("HD: Hi " + friendName
													+ "! This is Hemyush Deoli, the host of the world famous Canadian TV game show, 'Who wants to be a Millionare'\n");

											try {
												Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											int knowShow = rand.nextInt(2);// To show two different conversation

											if (knowShow == 1) {
												System.out.println(friendName
														+ ": Um... I don't know about that show, I think you called the wrong number. Please don't disturb me like this--\n");
												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}
												System.out.println("HD: Ummmmm.. " + friendName
														+ ", this is a very important call. Do you have a friend named "
														+ name + "?\n");
												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(friendName + ": Uh.... yes I guess.\n");
												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(name + ": Hey " + friendName + ", this is " + name
														+ " this side!!\n");
												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(friendName + ": OHHH Hey " + name
														+ "! It is actually you! Sorry I did not realize it!\n");
												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println("HD: It is okay " + friendName
														+ "! Maybe our show isn't that popular after all. Hehehheheh (*sigh*)\n");
												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
													System.out.print(". ");
												}

											}

											else {
												System.out.println(friendName
														+ ": OOOOH! That is my favourite Game show of all time! Thank you for calling! How can I help??!\n");
												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}
												System.out.println("HD: HAHAHAHAHA!! Glad to talk to a fan! "
														+ friendName
														+ ", this is a very important call. Do you have a friend named "
														+ name + "?\n");
												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out
														.println(friendName + ": Oooooh yes I do! Long time friend!\n");
												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(name + ": Hey " + friendName + ", this is " + name
														+ " this side!! \n");
												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(friendName + ": OHHH Hey " + name
														+ "! It is YOU! On the HotSeat! Lucky You! \n");
												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

											}

											System.out.println("HD: " + friendName + "! " + name
													+ " needs your help to solve a tricky Question. This question would earn him $"
													+ easyPrize[qNo - 1] + " if anwswered correctly!\n");
											try {
												Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println(friendName + ": ALRIGHT! I am ready! \n");
											try {
												Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println(
													"HD: Great! I will read out the question to you, and the options. You will have only 15 seconds to answer! Are You Ready? \n");
											try {
												Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println(friendName + ": Heck YES! \n");
											try {
												Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println(
													"HD: Alright! Here is the Question for you " + friendName + "! \n");
											try {
												Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println("\n" + questions[index] + "\n");

											for (String option : options[index]) {
												if (option != null) {

													try {
														Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
													} catch (InterruptedException e) {
														e.printStackTrace();
													}

													System.out.println(option);
												}
											}

											System.out.println("HD: " + friendName + "! Your Time Starts now!\n");

											try {
												Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											boolean friendAnswers = false;

											for (int a2 = 0; a2 < 15; a2++)// Slim chance your friend won't answer
											{

												System.out.println(".");

												try {
													Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												if (a2 > 4) {
													int doesAnswer = rand.nextInt(2);
													if (doesAnswer == 0) {
														friendAnswers = true;
														break;
													} else {
														continue;
													}
												}

												else {
													continue;
												}
											}

											if (friendAnswers == true) {
												do {
													Random random1 = new Random();

													// Get the options for the selected question
													String[] questionOptions = options[index];

													// Determine if the correct answer will be selected
													boolean isCorrect = random1.nextInt(100) < 75; // This is to check
																									// if friend answers
																									// correctly

													// Select an option based on whether it is correct or not
													selectedOptionPAF = isCorrect
															? questionOptions[getIndex(answers[index])]
															: questionOptions[random1.nextInt(questionOptions.length)];// 25%
																														// chance
																														// of
																														// being
																														// incorrect
												} while (selectedOptionPAF == null);// For 50-50

												System.out.println(
														"\n" + friendName + ": I think I know the answer! It is "
																+ (selectedOptionPAF) + "\n");

												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println("HD: Alright " + friendName
														+ "! Thank you for answering! Have a great day!\n");

												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(
														name + ": Thank You " + friendName + " for your help!\n");

												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(
														friendName + ": You are Welcome!! And Good Luck " + friendName
																+ "! Win that 1 million and share some with me!!\n");

												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println("*phone line cuts out*\n");

												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println("HD: Alright! " + friendName + " has Chose Option "
														+ selectedOptionPAF + " as their correct answer!\n");

												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(
														"HD: But I have a feeling that there is only a 75% chance that your friend gave the correct answer! So you still might need to use your own judgement!\n");

												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(
														"HD: Now I will list down the question for you again!\n");

												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

											}

											else // This is incase question is not answered
											{
												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}
												System.out.println("*phone line cuts away*\n");

												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println("HD: OH No!! It seems your friend " + friendName
														+ " was unable to answer the question in given time! Quite Unfortunate!\n");

												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(
														"HD: But the game must go on! You are now left without an important lifeline and an important friend!\n");

												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(
														"HD: I will list the question again for you! You are back to square one!\n");

												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

											}

											break;

										case "E":

											System.out.println("\nHD: Well Well! Now it is upto the audience to save "
													+ name + "'s RUN!\n");

											try {
												Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println(
													"HD: Audience, you will have 10 seconds to input your Answer Choice into the imaginary device we have TOTALLY provided you!\n");

											try {
												Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println(
													"HD: The result of the polls will be revealed after the 10 second time limit.\n");

											try {
												Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println(
													"HD: I will repeat the question and options for you! Be ready with your devices! Here is the question:\n");

											try {
												Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println("\n" + questions[index] + "\n");

											for (String option : options[index]) {
												if (option != null) {

													try {
														Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
													} catch (InterruptedException e) {
														e.printStackTrace();
													}

													System.out.println(option);
												}
											}

											try {
												Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println("\nHD: And Your time starts now!\n");

											try {
												Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											for (int a2 = 0; a2 < 10; a2++) {

												System.out.println(".");

												try {
													Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}
											}

											System.out.println(
													"HD: Time is up! Let us have a look at the result of the polls:\n\n");

											do {
												Random random1 = new Random();

												// Get the options for the selected question
												String[] questionOptions = options[index];

												// Determine if the correct answer will be selected
												boolean isCorrect = random1.nextInt(100) < 60;

												// Select an option based on whether it is correct or not
												selectedOptionATA = isCorrect
														? questionOptions[getIndex(answers[index])]
														: questionOptions[random1.nextInt(questionOptions.length)];
											} while (selectedOptionATA == null);

											Random randNo = new Random();

											if (!usedLifeline.contains("F")) // This is the poll
											{
												int pollPercent = randNo.nextInt(3) + 6;

												remainder = 10 - pollPercent - remainder;
												int part1 = randNo.nextInt(remainder); // generate a random number
																						// between 0 and number
												int part2 = randNo.nextInt(remainder - part1); // generate a random
																								// number between 0 and
																								// the remaining part
												int part3 = remainder - part1 - part2;

												Integer numObj1 = 1; // convert the int value to an Integer object

												Integer numObj2 = null; // set the Integer object to null

												Integer numObj3 = null;

												for (int i3 = 0; i3 < options[index].length; i3++) {

													String option = options[index][i3];

													if (option != null) {
														try {
															Thread.sleep(1000); // sleep for 1 second (1000
																				// milliseconds)
														} catch (InterruptedException e) {
															e.printStackTrace();
														}

														System.out.print(option + " ");
														if (selectedOptionATA == option) {
															for (int j1 = 0; j1 < pollPercent; j1++) {
																System.out.print("=");
															}
															System.out.print(" " + (pollPercent * 10) + "%\n");
														}

														else {

															if (numObj1 != null && numObj2 == null && numObj3 == null) {
																for (int j2 = 0; j2 < part1; j2++) {
																	System.out.print("=");
																}
																System.out.print(" " + (part1 * 10) + "%\n");
																numObj1 = null;
																numObj2 = 1;
																numObj3 = null;

															} else if (numObj1 == null && numObj2 != null
																	&& numObj3 == null) {
																for (int j2 = 0; j2 < part2; j2++) {
																	System.out.print("=");
																}
																System.out.print(" " + (part2 * 10) + "%\n");
																numObj1 = null;
																numObj2 = null;
																numObj3 = 1;

															}

															else if (numObj1 == null && numObj2 == null
																	&& numObj3 != null) {
																for (int j2 = 0; j2 < part3; j2++) {
																	System.out.print("=");
																}
																System.out.print(" " + (part3 * 10) + "%\n");

															}
														}
													}
												}
												try {
													Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}
												System.out.println(
														"\nHD: It looks like the majority of the people have chosen the same option as their answer.\n");

												try {
													Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(
														"\nHD: But personally, I don't think the audience we have here is the smartest cookie in the world.\n");

												try {
													Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println("\n*audible boos*\n");

												try {
													Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(
														"\nHD: I would say that the answer they provided has a 60% chance to be correct! So the chips are in your hands!\n");

												try {
													Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(
														"\nHD: I will repeat the question for you. What will your answer be??\n");

											}

											else if (usedLifeline.contains("F") && fiftyfiftyUsed == true)// To prevent
																											// 50-50
																											// options
																											// for a
																											// previously
																											// used
																											// 50-50
																											// lifeline
											{
												int pollPercent = randNo.nextInt(3) + 6;

												for (int i3 = 0; i3 < 2; i3++) {

													String option = options[index][i3];
													int randno = 0;
													randno = 10 - pollPercent;

													if (option != null) {
														try {
															Thread.sleep(1000); // sleep for 1 second (1000
																				// milliseconds)
														} catch (InterruptedException e) {
															e.printStackTrace();
														}

														System.out.print(option + " ");
														if (selectedOptionATA == option) {
															for (int j1 = 0; j1 < pollPercent; j1++) {
																System.out.print("=");
															}
															System.out.print(" " + (pollPercent * 10) + "%\n");
														}

														else {
															for (int j2 = 0; j2 < randno; j2++) {
																System.out.print("=");
															}
															System.out.print(" " + (randno * 10) + "%\n");
															remainder = randno;

														}
													}
												}

												try {
													Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}
												System.out.println(
														"\nHD: It looks like the majority of the people have chosen the same option as their answer.\n");

												try {
													Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(
														"\nHD: But personally, I don't think the audience we have here is the smartest cookie in the world.\n");

												try {
													Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println("\n*audible boos*\n");

												try {
													Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(
														"\nHD: I would say that the answer they provided has a 60% chance to be correct! So the chips are in your hands!\n");

												try {
													Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(
														"\nHD: I will repeat the question for you. What will your answer be??\n");

											}
											break;
										}

										continue;
									}

									else {

										System.out.println("\nOkay Re - Enter Your choice\n");

										continue;
									}
								}

								else if (usedLifeline.contains(answerOption)) { // This is for already used lifeline
									int indexLL = usedLifeline.indexOf(answerOption);

									System.out.println("\nYou have already used your \"" + (usedLL.get(indexLL))
											+ "\" lifeline. \n");

									try {
										Thread.sleep(3000); // sleep for 1 second (1000 milliseconds)
									} catch (InterruptedException e) {
										e.printStackTrace();
									}

									System.out.println("\nPlease Re-Enter Your choice\n");

									continue;
								}

								else {
									System.out.println("\nInvalid input. Please try again.\n");
									continue;
								}

							}
							if (walkAway) {
								break;
							}
						}

						if (walkAway) {
							break;
						}

						round++;

						if (round > 0 && round != 3) {
							System.out.println(
									"\nDo you wish to continue to the next round (Any Key) or \nDo you want to walk away with your prize money (W)?");
							String walkAwayChoice = input.nextLine();

							System.out.println();

							if (walkAwayChoice.equalsIgnoreCase("W")) {
								System.out.println("\nYou decided to Walk Away!!");

								try {
									Thread.sleep(3000); // sleep for 1 second (1000 milliseconds)
								} catch (InterruptedException e) {
									e.printStackTrace();
								}

								System.out.println("\nCongratulations! You are leaving with a Prize Money of $"
										+ (prizeMoney) + "!!");

								try {
									Thread.sleep(3000); // sleep for 1 second (1000 milliseconds)
								} catch (InterruptedException e) {
									e.printStackTrace();
								}

								System.out.println("\nWe Hope To See You Again!");

								walkAway = true;
							}

							else {
								continue;
							}
						}

						else if (round == 3) {
							System.out.println("\nYou have won all 3 rounds and you are now a MILLIONARE!!!");

							try {
								Thread.sleep(6000); // sleep for 1 second (1000 milliseconds)
							} catch (InterruptedException e) {
								e.printStackTrace();
							}

							System.out.println("\nCongratulations " + name + " for this massive win!");

							try {
								Thread.sleep(3000); // sleep for 1 second (1000 milliseconds)
							} catch (InterruptedException e) {
								e.printStackTrace();
							}

							System.out.println("\nWe Hope To See You Again!\n");
						}

					}

					break;

				/*
				 * *****************************************************************************
				 * ****
				 */

				case "h": // Hard Difficulty

					System.out.println("\nWelcome " + name + " to \"Who Wants to be a Millionare\"!\n");

					try {
						Thread.sleep(3000); // sleep for 1 second (1000 milliseconds)
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println("\nLet us begin your journey towards becoming a millionare!! \n");

					try {
						Thread.sleep(3000); // sleep for 1 second (1000 milliseconds)
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println("\nHere is the recap of the rules:");

					try {
						Thread.sleep(3000); // sleep for 1 second (1000 milliseconds)
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println("\n- There will be 3 rounds of questions with 5 questions each.\n");

					try {
						Thread.sleep(3000); // sleep for 1 second (1000 milliseconds)
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println(
							"\n- After answering correctly 5 times, you would have the oppurtunity to either \' Walk Away \' with the prize money you have won till that point, or keep going.\n");

					try {
						Thread.sleep(3000); // sleep for 1 second (1000 milliseconds)
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println("\n- For each question you will have lifelines available after round 2:\n");

					try {
						Thread.sleep(3000); // sleep for 1 second (1000 milliseconds)
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println("\n '50-50' - Removes two incorrect options\n");

					try {
						Thread.sleep(3000); // sleep for 1 second (1000 milliseconds)
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println(
							"\n 'Phone A Friend' - Calls up a friend of your choosimg, who will have 75% chance of giving you the correct answer, but also have a '1/1024 th' chance to not answer at all. \n");

					try {
						Thread.sleep(3000); // sleep for 1 second (1000 milliseconds)
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println(
							"\n 'Audience Poll' - Asks the audience to choose an answer for you, with a 60% chance of the answer chosen being correct.\n");

					try {
						Thread.sleep(3000); // sleep for 1 second (1000 milliseconds)
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println("\n- That's it for the Rules!\n");

					try {
						Thread.sleep(3000); // sleep for 1 second (1000 milliseconds)
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					while (round < 3 && !walkAway) {

						System.out.println("We begin with Round " + (round + 1) + "!!\n");

						try {
							Thread.sleep(2000); // sleep for 1 second (1000 milliseconds)
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

						for (int i = 0; i < 5; i++) { // To have 3 questions for each round

							doneQues = false; // To check whether a question has been completed
							qNo++; // To display Question Number

							System.out.println("Your current earnings are $" + prizeMoney);

							try {
								Thread.sleep(2000); // sleep for 1 second (1000 milliseconds)
							} catch (InterruptedException e) {
								e.printStackTrace();
							}

							System.out.println("\nQuestion " + (qNo) + " is for $" + (hardPrize[qNo - 1]) + "\n\n"); // To
																														// make
																														// the
																														// index
																														// of
																														// easyPrize
																														// '0'
																														// at
																														// first

							if (hardPrize[qNo - 1] == 1000000) // Special Message for million dollar question
							{
								try {
									Thread.sleep(2000); // sleep for 1 second (1000 milliseconds)
								} catch (InterruptedException e) {
									e.printStackTrace();
								}

								System.out.println("\nThis is the final question!!!\nGood Luck!!!");
							}

							try {
								Thread.sleep(2000); // sleep for 1 second (1000 milliseconds)
							} catch (InterruptedException e) {
								e.printStackTrace();
							}

							// To get question

							int index = indices.get(j); // Indices is a list, with a shuffled question order
							while (usedIndices.contains(index)) { // If question has been used before, get a new
																	// question
								index = indices.get(j);
							}
							usedIndices.add(index); // Mark the question as used

							j++; // to get the next question

							while (!doneQues) // Till the answer choice is given
							{
								// To get options
								System.out.println("Question " + (qNo) + ": " + questions[index] + "\n"); // To print
																											// question,
																											// based on
																											// Indices

								for (String option : options[index]) { // To print options by iterating through the
																		// 'options' Array

									if (option != null) { // This is used to check for 50-50

										try {
											Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
										} catch (InterruptedException e) {
											e.printStackTrace();
										}

										System.out.println(option);
									}
								}

								try {
									Thread.sleep(2000); // sleep for 1 second (1000 milliseconds)
								} catch (InterruptedException e) {
									e.printStackTrace();
								}

								System.out.print("\nEnter ");

								for (int s = 0; s < 4; s++) // To print from A to D, but changes when 50-50 is applied
								{
									if (!nullOptions.contains(answerChoice.get(s).charAt(0))) {
										System.out.print("'" + answerChoice.get(s) + "' ");
									}

								}

								System.out.print("to choose an option\n\n");

								try {
									Thread.sleep(2000); // sleep for 1 second (1000 milliseconds)
								} catch (InterruptedException e) {
									e.printStackTrace();
								}

								if (!lifelines.isEmpty() && round >= 1 && qNo ==5) { // This block of code is to print available // lifelines

								System.out.println("\n Now you have lifelines \n");

								try {
									Thread.sleep(2000); // sleep for 1 second (1000 milliseconds)
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								}
								
								if (!lifelines.isEmpty() && round >= 1) { // This block of code is to print available
																			// lifelines



									System.out.println("Remaining lifelines: " + lifelines + "\n");

									try {
										Thread.sleep(2000); // sleep for 1 second (1000 milliseconds)
									} catch (InterruptedException e) {
										e.printStackTrace();
									}

									System.out.println("To choose a lifeline press:\n");

									for (int l = 0; l < lifelines.size(); l++) {

										try {
											Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
										} catch (InterruptedException e) {
											e.printStackTrace();
										}

										System.out.print("Press \"" + (lifelineOption.get(l)) + "\" for "
												+ (lifelines.get(l)) + "\n"); // TO print F, P and E based on available
																				// lifelines

									}
								}

								else if (lifelines.isEmpty() && round >= 1) {
									System.out.println("Remaining lifelines: YOU HAVE NO LIFELINES LEFT (GOOD LUCK)\n");
								}

								else {
									System.out.println("YOU HAVE NO LIFELINES FOR ROUND 1 (GOOD LUCK)\n");
								}

								try {
									Thread.sleep(2000); // sleep for 1 second (1000 milliseconds)
								} catch (InterruptedException e) {
									e.printStackTrace();
								}

								System.out.println("\nEnter Your Choice: "); // To enter the available options -
																				// lifeline or answer

								String answerOption = input.nextLine().toUpperCase(); // They are uppercase for easier
																						// comparison
								char charAnswerOption = answerOption.charAt(0); // To make the option a char type for
																				// comparison

								if (answerChoice.contains(answerOption) && !nullOptions.contains(charAnswerOption)) { // To
																														// check
																														// for
																														// available
																														// options,
																														// even
																														// in
																														// case
																														// for
																														// 50-50
																														// remove.
																														// This
																														// code
																														// is
																														// for
																														// eligible
																														// option

									System.out.print("\nIs the option '");

									for (int i1 = 0; i1 < 4; i1++) // This will iterate through options, to find the one
																	// matching the initial alphabet as the answerChoice
									{
										if (options[index][i1] == null) {
											continue;
										}

										else if (options[index][i1].charAt(0) == charAnswerOption) {
											System.out.print(options[index][i1]);
										}
									}

									System.out.print("' your final answer? \nY for YES \nN (or any key) for NO\n");

									String answerConfirm = input.nextLine(); // For Yes Or No

									if (answerConfirm.equalsIgnoreCase("y")) { // To check if the answer is correct or
																				// not

										for (int l = 0; l < 3; l++) {

											System.out.println(".");

											try {
												Thread.sleep(800); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}
										}

										if (answerOption.equals(answers[index])) {// If answer is correct
											doneQues = true;
											fiftyfiftyUsed = false; // So that it resets and is not used for future Ask
																	// the Audience because the ATA logic requires a
																	// check for 50-50

											System.out.println("Correct Answer!!");
											prizeMoney = hardPrize[qNo - 1];

											if (prizeMoney != 1000000) {// To show prize money till its not a million
												System.out.println("You have won $" + prizeMoney);

												try {
													Thread.sleep(800); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println("\nOnto the Next Question!\n");

												try {
													Thread.sleep(800); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

											}
											nullOptions.clear();// For future checks of other question. Just so that the
																// 50-50 removed questions are available

											try {
												Thread.sleep(800); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

										}

										else {// This loop is for Incorrect Answer
											System.out.println("\nIncorrect Answer!!");

											try {
												Thread.sleep(800); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											for (int a3 = 0; a3 < 4; a3++)// To display the correct answer
											{
												if (options[index][a3].charAt(0) == answers[index].charAt(0)) {
													correctAnswer = options[index][a3];
												}
											}
											System.out.println("\nThe Correct Answer is: " + (correctAnswer));

											try {
												Thread.sleep(800); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println(
													"\nSorry You Have Lost the Game and all your Prize Money  :(");

											try {
												Thread.sleep(800); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											incorrectAns = 1; // To get out after answering Incorrectly
										}

										if (incorrectAns == 1) {
											doneQues = true;
											walkAway = true;

										}

									}

									else {// This is the No option to confirm your answer Choice. If you press A but are
											// not sure.
										System.out.println("\nOkay Re - Enter Your choice\n");
										continue;
									}
								}

								// Lifeline Use!

								else if (lifelineOption.contains(answerOption) && round >= 1) { // If answer Choice is
																								// one of the
									// lifelines.

									System.out.println("\nDo you wish to use your \""
											+ lifelines.get(lifelineOption.indexOf(answerOption))
											+ "\" lifeline?\nY for YES \nN (or any key) for NO"); // To confirm uiuf you
																									// want to use
																									// lifeline

									String lifelineConfirm = input.nextLine();

									if (lifelineConfirm.equalsIgnoreCase("y"))

									{

										usedLifeline.add(answerOption);// To not be able to use lifeline in future
										int indexLifeline = lifelineOption.indexOf(answerOption);
										usedLL.add(lifelines.get(indexLifeline));// To not be able to use lifeline
																					// character

										System.out.println("\nYou decided to use up your \""
												+ lifelines.get(indexLifeline) + "\" lifeline!");

										try {
											Thread.sleep(2000); // sleep for 1 second (1000 milliseconds)
										} catch (InterruptedException e) {
											e.printStackTrace();
										}

										lifelines.remove(indexLifeline);
										lifelineOption.remove(indexLifeline);

										switch (answerOption) {// When answer Option is one of the Lifelines

										case "F":

											fiftyfiftyUsed = true;

											System.out.println(
													"\nWe will now remove two of the incorrect options from the screen.");

											try {
												Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println(
													"\nHere is the question again with the two of the incorrect options removed!!\n");

											try {
												Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											String[][] incorrectAnswers = new String[1][3];

											for (int m = 0; m < 4; m++) {
												if (!options[index][m].startsWith(answers[index])) {// If the options do
																									// not start with
																									// the character of
																									// correct answer
													incorrectAnswers[0][k] = options[index][m];
													k++;
												}
											}

											Random random = new Random();
											int randomNumber = random.nextInt(3);

											String[][] newOptions = new String[1][2];

											String correctResult = new String();

											for (String option : options[index]) {
												if (option.startsWith(answers[index])) {
													correctResult = option;
													break;
												}
											}

											newOptions[0][0] = correctResult;
											newOptions[0][1] = incorrectAnswers[0][randomNumber];
											Arrays.sort(newOptions[0]);// To sort alphabetically

											for (int s = 0; s < 3; s++) {// To add the removed options to nullOptions,
																			// so that they can't be used.
												if (s != randomNumber) {
													nullOptions.add(incorrectAnswers[0][s].charAt(0));
												}
											}

											for (int a = 0; a < 1; a++) {
												for (int m = 0; m < 4; m++) {
													if (m < 2) {
														options[index][m] = newOptions[a][m];
													} else {
														options[index][m] = null;// The options after 50-50 will be
																					// checked if they are null and
																					// won't displayed
													}
												}
											}

											break;

										case "P":

											System.out.println(
													"\nALRIGHT! Since you have decided to use your 'Phone A Friend' Lifeline, please tell us the name of your friend:");

											String friendName = input.nextLine();

											System.out.println(
													"\nAlright, Mr. Computer! Please try and contact our contestant, "
															+ name + "'s friend, " + friendName + "! \n");

											Random rand = new Random();
											int callDuration1 = rand.nextInt(3) + 4;

											for (int m = 0; m < callDuration1; m++) {
												for (int n = 0; n < 3; n++) {
													try {
														Thread.sleep(700); // sleep for 1 second (1000 milliseconds)
													} catch (InterruptedException e) {
														e.printStackTrace();
													}
													System.out.print(". ");
												}
												System.out.println();

											}

											System.out.println("*picks up reciever..*\n");

											try {
												Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println(friendName + ": Hello!\n");

											try {
												Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println("HD: Am I speaking with " + friendName + "?\n");

											try {
												Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println(friendName + ": Yes, who's speaking?\n");

											try {
												Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println("HD: Hi " + friendName
													+ "! This is Hemyush Deoli, the host of the world famous Canadian TV game show, 'Who wants to be a Millionare'\n");

											try {
												Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											int knowShow = rand.nextInt(2);// To show two different conversation

											if (knowShow == 1) {
												System.out.println(friendName
														+ ": Um... I don't know about that show, I think you called the wrong number. Please don't disturb me like this--\n");
												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}
												System.out.println("HD: Ummmmm.. " + friendName
														+ ", this is a very important call. Do you have a friend named "
														+ name + "?\n");
												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(friendName + ": Uh.... yes I guess.\n");
												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(name + ": Hey " + friendName + ", this is " + name
														+ " this side!!\n");
												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(friendName + ": OHHH Hey " + name
														+ "! It is actually you! Sorry I did not realize it!\n");
												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println("HD: It is okay " + friendName
														+ "! Maybe our show isn't that popular after all. Hehehheheh (*sigh*)\n");
												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
													System.out.print(". ");
												}

											}

											else {
												System.out.println(friendName
														+ ": OOOOH! That is my favourite Game show of all time! Thank you for calling! How can I help??!\n");
												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}
												System.out.println("HD: HAHAHAHAHA!! Glad to talk to a fan! "
														+ friendName
														+ ", this is a very important call. Do you have a friend named "
														+ name + "?\n");
												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out
														.println(friendName + ": Oooooh yes I do! Long time friend!\n");
												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(name + ": Hey " + friendName + ", this is " + name
														+ " this side!! \n");
												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(friendName + ": OHHH Hey " + name
														+ "! It is YOU! On the HotSeat! Lucky You! \n");
												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

											}

											System.out.println("HD: " + friendName + "! " + name
													+ " needs your help to solve a tricky Question. This question would earn him $"
													+ hardPrize[qNo - 1] + " if anwswered correctly!\n");
											try {
												Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println(friendName + ": ALRIGHT! I am ready! \n");
											try {
												Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println(
													"HD: Great! I will read out the question to you, and the options. You will have only 15 seconds to answer! Are You Ready? \n");
											try {
												Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println(friendName + ": Heck YES! \n");
											try {
												Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println(
													"HD: Alright! Here is the Question for you " + friendName + "! \n");
											try {
												Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println("\n" + questions[index] + "\n");

											for (String option : options[index]) {
												if (option != null) {

													try {
														Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
													} catch (InterruptedException e) {
														e.printStackTrace();
													}

													System.out.println(option);
												}
											}

											System.out.println("HD: " + friendName + "! Your Time Starts now!\n");

											try {
												Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											boolean friendAnswers = false;

											for (int a2 = 0; a2 < 15; a2++)// Slim chance your friend won't answer
											{

												System.out.println(".");

												try {
													Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												if (a2 > 4) {
													int doesAnswer = rand.nextInt(2);
													if (doesAnswer == 0) {
														friendAnswers = true;
														break;
													} else {
														continue;
													}
												}

												else {
													continue;
												}
											}

											if (friendAnswers == true) {
												do {
													Random random1 = new Random();

													// Get the options for the selected question
													String[] questionOptions = options[index];

													// Determine if the correct answer will be selected
													boolean isCorrect = random1.nextInt(100) < 75; // This is to check
																									// if friend answers
																									// correctly

													// Select an option based on whether it is correct or not
													selectedOptionPAF = isCorrect
															? questionOptions[getIndex(answers[index])]
															: questionOptions[random1.nextInt(questionOptions.length)];// 25%
																														// chance
																														// of
																														// being
																														// incorrect
												} while (selectedOptionPAF == null);// For 50-50

												System.out.println(
														"\n" + friendName + ": I think I know the answer! It is "
																+ (selectedOptionPAF) + "\n");

												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println("HD: Alright " + friendName
														+ "! Thank you for answering! Have a great day!\n");

												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(
														name + ": Thank You " + friendName + " for your help!\n");

												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(
														friendName + ": You are Welcome!! And Good Luck " + friendName
																+ "! Win that 1 million and share some with me!!\n");

												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println("*phone line cuts out*\n");

												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println("HD: Alright! " + friendName + " has Chose Option "
														+ selectedOptionPAF + " as their correct answer!\n");

												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(
														"HD: But I have a feeling that there is only a 75% chance that your friend gave the correct answer! So you still might need to use your own judgement!\n");

												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(
														"HD: Now I will list down the question for you again!\n");

												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

											}

											else // This is incase question is not answered
											{
												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}
												System.out.println("*phone line cuts away*\n");

												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println("HD: OH No!! It seems your friend " + friendName
														+ " was unable to answer the question in given time! Quite Unfortunate!\n");

												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(
														"HD: But the game must go on! You are now left without an important lifeline and an important friend!\n");

												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(
														"HD: I will list the question again for you! You are back to square one!\n");

												try {
													Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

											}
											break;

										case "E":

											System.out.println("\nHD: Well Well! Now it is upto the audience to save "
													+ name + "'s RUN!\n");

											try {
												Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println(
													"HD: Audience, you will have 10 seconds to input your Answer Choice into the imaginary device we have TOTALLY provided you!\n");

											try {
												Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println(
													"HD: The result of the polls will be revealed after the 10 second time limit.\n");

											try {
												Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println(
													"HD: I will repeat the question and options for you! Be ready with your devices! Here is the question:\n");

											try {
												Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println("\n" + questions[index] + "\n");

											for (String option : options[index]) {
												if (option != null) {

													try {
														Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
													} catch (InterruptedException e) {
														e.printStackTrace();
													}

													System.out.println(option);
												}
											}

											try {
												Thread.sleep(2500); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											System.out.println("\nHD: And Your time starts now!\n");

											try {
												Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
											} catch (InterruptedException e) {
												e.printStackTrace();
											}

											for (int a2 = 0; a2 < 10; a2++) {

												System.out.println(".");

												try {
													Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}
											}

											System.out.println(
													"HD: Time is up! Let us have a look at the result of the polls:\n\n");

											do {
												Random random1 = new Random();

												// Get the options for the selected question
												String[] questionOptions = options[index];

												// Determine if the correct answer will be selected
												boolean isCorrect = random1.nextInt(100) < 60;

												// Select an option based on whether it is correct or not
												selectedOptionATA = isCorrect
														? questionOptions[getIndex(answers[index])]
														: questionOptions[random1.nextInt(questionOptions.length)];
											} while (selectedOptionATA == null);

											Random randNo = new Random();

											if (!usedLifeline.contains("F")) // This is the poll
											{
												int pollPercent = randNo.nextInt(3) + 6;

												remainder = 10 - pollPercent - remainder;
												int part1 = randNo.nextInt(remainder); // generate a random number
																						// between 0 and number
												int part2 = randNo.nextInt(remainder - part1); // generate a random
																								// number between 0 and
																								// the remaining part
												int part3 = remainder - part1 - part2;

												Integer numObj1 = 1; // convert the int value to an Integer object

												Integer numObj2 = null; // set the Integer object to null

												Integer numObj3 = null;

												for (int i3 = 0; i3 < options[index].length; i3++) {

													String option = options[index][i3];

													if (option != null) {
														try {
															Thread.sleep(1000); // sleep for 1 second (1000
																				// milliseconds)
														} catch (InterruptedException e) {
															e.printStackTrace();
														}

														System.out.print(option + " ");
														if (selectedOptionATA == option) {
															for (int j1 = 0; j1 < pollPercent; j1++) {
																System.out.print("=");
															}
															System.out.print(" " + (pollPercent * 10) + "%\n");
														}

														else {

															if (numObj1 != null && numObj2 == null && numObj3 == null) {
																for (int j2 = 0; j2 < part1; j2++) {
																	System.out.print("=");
																}
																System.out.print(" " + (part1 * 10) + "%\n");
																numObj1 = null;
																numObj2 = 1;
																numObj3 = null;

															} else if (numObj1 == null && numObj2 != null
																	&& numObj3 == null) {
																for (int j2 = 0; j2 < part2; j2++) {
																	System.out.print("=");
																}
																System.out.print(" " + (part2 * 10) + "%\n");
																numObj1 = null;
																numObj2 = null;
																numObj3 = 1;

															}

															else if (numObj1 == null && numObj2 == null
																	&& numObj3 != null) {
																for (int j2 = 0; j2 < part3; j2++) {
																	System.out.print("=");
																}
																System.out.print(" " + (part3 * 10) + "%\n");

															}
														}
													}
												}
												try {
													Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}
												System.out.println(
														"\nHD: It looks like the majority of the people have chosen the same option as their answer.\n");

												try {
													Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(
														"\nHD: But personally, I don't think the audience we have here is the smartest cookie in the world.\n");

												try {
													Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println("\n*audible boos*\n");

												try {
													Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(
														"\nHD: I would say that the answer they provided has a 60% chance to be correct! So the chips are in your hands!\n");

												try {
													Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(
														"\nHD: I will repeat the question for you. What will your answer be??\n");

											}

											else if (usedLifeline.contains("F") && fiftyfiftyUsed == true)// To prevent
																											// 50-50
																											// options
																											// for a
																											// previously
																											// used
																											// 50-50
																											// lifeline
											{
												int pollPercent = randNo.nextInt(3) + 6;

												for (int i3 = 0; i3 < 2; i3++) {

													String option = options[index][i3];
													int randno = 0;
													randno = 10 - pollPercent;

													if (option != null) {
														try {
															Thread.sleep(1000); // sleep for 1 second (1000
																				// milliseconds)
														} catch (InterruptedException e) {
															e.printStackTrace();
														}

														System.out.print(option + " ");
														if (selectedOptionATA == option) {
															for (int j1 = 0; j1 < pollPercent; j1++) {
																System.out.print("=");
															}
															System.out.print(" " + (pollPercent * 10) + "%\n");
														}

														else {
															for (int j2 = 0; j2 < randno; j2++) {
																System.out.print("=");
															}
															System.out.print(" " + (randno * 10) + "%\n");
															remainder = randno;

														}
													}
												}

												try {
													Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}
												System.out.println(
														"\nHD: It looks like the majority of the people have chosen the same option as their answer.\n");

												try {
													Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(
														"\nHD: But personally, I don't think the audience we have here is the smartest cookie in the world.\n");

												try {
													Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println("\n*audible boos*\n");

												try {
													Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(
														"\nHD: I would say that the answer they provided has a 60% chance to be correct! So the chips are in your hands!\n");

												try {
													Thread.sleep(1000); // sleep for 1 second (1000 milliseconds)
												} catch (InterruptedException e) {
													e.printStackTrace();
												}

												System.out.println(
														"\nHD: I will repeat the question for you. What will your answer be??\n");

											}
											break;
										}

										continue;
									}

									else {

										System.out.println("\nOkay Re - Enter Your choice\n");

										continue;
									}
								}

								else if (lifelineOption.contains(answerOption) && round == 0) {
									System.out.println("\nYou cannot use lifelines till Round 2!\n");

									try {
										Thread.sleep(3000); // sleep for 1 second (1000 milliseconds)
									} catch (InterruptedException e) {
										e.printStackTrace();
									}

									System.out.println("\nPlease Re-Enter Your choice\n");

									continue;
								}

								else if (usedLifeline.contains(answerOption) && round >= 1) { // This is for already
																								// used lifeline
									int indexLL = usedLifeline.indexOf(answerOption);

									System.out.println("\nYou have already used your \"" + (usedLL.get(indexLL))
											+ "\" lifeline. \n");

									try {
										Thread.sleep(3000); // sleep for 1 second (1000 milliseconds)
									} catch (InterruptedException e) {
										e.printStackTrace();
									}

									System.out.println("\nPlease Re-Enter Your choice\n");

									continue;
								}

								else {
									System.out.println("\nInvalid input. Please try again.\n");
									continue;
								}

							}
							if (walkAway) {
								break;
							}
						}

						if (walkAway) {
							break;
						}

						round++;

						if (round > 0 && round != 3) {
							
							System.out.println(
									"\nBut before moving on!! You have the option to walk away with the prize money you have earned till now");
							

							try {
								Thread.sleep(2000); // sleep for 1 second (1000 milliseconds)
							} catch (InterruptedException e) {
								e.printStackTrace();
							}

							
							System.out.println(
									"\nDo you wish to continue to the next round (Any Key) or \nDo you want to walk away with your current prize money (W)?");
							String walkAwayChoice = input.nextLine();

							System.out.println();

							if (walkAwayChoice.equalsIgnoreCase("W")) {
								System.out.println("\nYou decided to Walk Away!!");

								try {
									Thread.sleep(2000); // sleep for 1 second (1000 milliseconds)
								} catch (InterruptedException e) {
									e.printStackTrace();
								}

								System.out.println("\nCongratulations! You are leaving with a Prize Money of $"
										+ (prizeMoney) + "!!");

								try {
									Thread.sleep(3000); // sleep for 1 second (1000 milliseconds)
								} catch (InterruptedException e) {
									e.printStackTrace();
								}

								System.out.println("\nWe Hope To See You Again!");

								walkAway = true;
							}

							else {
								continue;
							}
						}

						else if (round == 3) {
							System.out.println("\nYou have won all 3 rounds and you are now a MILLIONARE!!!");

							try {
								Thread.sleep(6000); // sleep for 1 second (1000 milliseconds)
							} catch (InterruptedException e) {
								e.printStackTrace();
							}

							System.out.println("\nCongratulations " + name + " for this massive win!");

							try {
								Thread.sleep(3000); // sleep for 1 second (1000 milliseconds)
							} catch (InterruptedException e) {
								e.printStackTrace();
							}

							System.out.println("\nWe Hope To See You Again!\n");
						}

					}

					break;

				/*
				 * *****************************************************************************
				 * ****
				 */

				default:
					System.out.println("\nInvalid input. Please try again.");
					continue;

				}
				/**************************************************************************************** */
				System.out.println("\nByeBye!");
				input.close();
				System.exit(0);

				break;

			/**************************************************************************** */

			case 2:

				System.out.println("\nRULES OF THE GAME:\n");
				System.out.println(
						"- There will be 3 rounds of questions with 3 questions each in Easy Mode, and 5 questions each in Hard mode.\n");

				System.out.println(
						"- After answering correctly 3 times in Easy Mode / 5 times in Hard Mode , you would have the oppurtunity to either \' Walk Away \' with the prize money you have won till that point, or keep going. We will disclose the amount for each question during the game itself for a surprise!\n");

				System.out.println("- For each question you will have lifelines available:\n");

				System.out.println(" '50-50' - Removes two incorrect options\n");

				System.out.println(
						" 'Phone A Friend' - Calls up a friend of your choosimg, who will have 75% chance of giving you the correct answer, but also have a '1/1024 th' chance to not answer at all. \n");

				System.out.println(
						" 'Audience Poll' - Asks the audience to choose an answer for you, with a 60% chance of the answer chosen being correct.\n");

				System.out.println(
						"You can press 'B' to go back to the START Menu or press any other key to exit the game.\n");
				try {
					String choice2 = input.next();
					if (choice2.equals("B")) {
						continue;
					}

					else {
						System.out.println("\nByeBye!");
						input.close();
						System.exit(0);
						break;
					}
				} catch (InputMismatchException e) {
					input.close();
					System.exit(0);
					break;
				}

				/*********************************************************************** */

			case 3:
				System.out.println("\nByeBye!!!");
				input.close();
				System.exit(0);

				break;
			/*********************************************************************** */

			default:
				System.out.println("\nInvalid input. Please try again.");
				continue;
			}

		}
	}

	private static int getIndex(String answer) {
		switch (answer) {
		case "A":
			return 0;
		case "B":
			return 1;
		case "C":
			return 2;
		case "D":
			return 3;
		default:
			return -1;
		}
	}
}
