using System.Collections;
using System.Collections.Generic;
using System.Threading;
using UnityEngine;
//At the top of GameManager.cs, add “using TMPro;”
using TMPro;
public class GameManager : MonoBehaviour
{
    public List<GameObject> targets;
    // Declare and initialize a new private float spawnRate variable
    private float spawnRate = 1.0f;
    //Declare a new public TextMeshProUGUI scoreText, then assign that variable in the inspector
    public TextMeshProUGUI scoreText;
    //Create a new private int score
    private int score;
    // Game Over text
    public TextMeshProUGUI gameOverText;

    // Start is called before the first frame update
    void Start()
    {
        // In Start(), use the StartCoroutine method to begin spawning objects
        StartCoroutine(SpawnTarget());
        //score variable and initialize it in Start() as score = 0;
        score = 0;
        UpdateScore(0);
    }

    // Update is called once per frame
    void Update()
    {
        
    }

// Create a new IEnumerator SpawnTarget() method
    IEnumerator SpawnTarget()
    {
        // Inside the new method, while(true), wait 1 second, generate a random index, and spawn a random target
        while (true)
        {
            yield return new WaitForSeconds(spawnRate);
            Instantiate(targets[Random.Range(0, targets.Count)]);
        }
    }

    //  Method for add score
    public void UpdateScore(int scoreToAdd)
    {
        // Increase the score
        score += scoreToAdd;
        // Score text
        scoreText.text = "Score: " + score;
    }

    public void GameOver()
    {
        // activate the Game Over text
        gameOverText.gameObject.SetActive(true);
    }

}

