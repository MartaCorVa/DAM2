using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using MySqlDataAccessLibrary;
using UnityEngine.UI;

public class Collectible : MonoBehaviour
{
    private GameObject gameManagerObject;
    private GameManager gameManager;

    // Start is called before the first frame update
    void Start()
    {
        gameManagerObject = GameObject.Find("Game Manager");
        gameManager = gameManagerObject.GetComponent<GameManager>();

        DataAccess dataAccess = new DataAccess();
        gameObject.GetComponentInChildren<Text>().text = dataAccess.GetRandomBook().Title;
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    private void OnTriggerEnter(Collider other)
    {
       if (other.gameObject.name == "FPSController")
        {
            gameManager.AddToScore(1);
            Debug.Log("Score: " + gameManager.GetScore());
            Destroy(gameObject);
        }
    }
}
