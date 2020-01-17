using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;
using UnityStandardAssets.Characters.FirstPerson;

public class ScoreControl : MonoBehaviour
{
    [SerializeField]
    private Canvas playerWin;
    public int score;
    [SerializeField]
    private GameObject player;
    [SerializeField]
    private GameObject bullet;

    public int AddScore()
    {
        return score++;
    }

    // Start is called before the first frame update
    void Start()
    {
        score = 0;
        playerWin.enabled = false;        
    }

    // Update is called once per frame
    void Update()
    {
        if (score == 5)
        {
            player.GetComponent<FirstPersonController>().enabled = false;
            bullet.GetComponent<BookCreator>().enabled = false;
            Cursor.lockState = CursorLockMode.None;
            Cursor.visible = true;
            playerWin.enabled = true;
        }
    }

    public void GoToMenu()
    {
        SceneManager.LoadScene("Main Menu");
    }

    public void QuitGame()
    {
        Application.Quit();
    }
}
