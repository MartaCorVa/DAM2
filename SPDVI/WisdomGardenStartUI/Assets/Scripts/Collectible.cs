using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using MySqlDataAccessLibrary;
using UnityEngine.UI;

public class Collectible : MonoBehaviour
{
    private GameObject gameManagerObject;
    private GameManager gameManager;
    private int count = 0;

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
            gameObject.transform.localScale /= 2.0f;
            count++;
            if (count == 3)
            {
            gameManager.AddToScore(1);
            Destroy(gameObject);
            }
            
        }
    }
}
